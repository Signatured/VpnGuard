package me.signatured.vpnguardshared.network.util.json;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import org.jooq.lambda.fi.util.function.CheckedBiConsumer;
import org.jooq.lambda.fi.util.function.CheckedFunction;

import com.google.common.base.Charsets;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * An JsonIO utility class for JSON-based data manipulation.
 * @author Brittan Thomas
 */
public class JsonIO {
	/**
	 * Saves the specified data to the specified file.
	 * @param file - the specified file to save to.
	 * @param value - the value to extract data from.
	 */
	public static <T> void save(File file, T value) {
		save(file, value, false);
	}

	/**
	 * Saves the specified data to the specified file.
	 * @param file - the specified file to save to.
	 * @param value - the value to extract data from.
	 * @param append - if the data should be appended to the current file.
	 */
	public static <T> void save(File file, T value, boolean append) {
		file.getAbsoluteFile().getParentFile().mkdirs();
		FileOutputStream stream = null;
		OutputStreamWriter osw = null;
		BufferedWriter writer = null;
		try {
			try {
				stream = new FileOutputStream(file, append);
				osw = new OutputStreamWriter(stream, Charsets.UTF_8);
				writer = new BufferedWriter(osw);
				GSON.toJson(value, writer);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (writer != null)
					writer.close();
				if (osw != null)
					osw.close();
				if (stream != null)
					stream.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the specified file from the specified class adapter.
	 * @param file - the specified file to load data from.
	 * @param class - the specified class to adapt for.
	 * @return the newly loaded instance from the specified data.
	 */
	public static <T> T load(File file, Class<T> clazz) {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		InputStreamReader reader = null;
		try {
			try {
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				reader = new InputStreamReader(bis, Charsets.UTF_8);
				return GSON.fromJson(reader, clazz);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (reader != null)
					reader.close();
				if (bis != null)
					bis.close();
				if (fis != null)
					fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Gets the specified data in "pretty" json-string format.
	 * @param value - the value to extract data from.
	 * @return the specified data converted to "pretty" json-string format.
	 */
	public static <T> String save(T value) {
		return save(value, true);
	}

	/**
	 * Gets the specified data in raw json-string format.
	 * @param value - the value to extract data from.
	 * @return the specified data converted to raw json-string format.
	 */
	public static <T> String saveRaw(T value) {
		return save(value, false);
	}

	/**
	 * Gets the specified data in json-string format.
	 * @param value - the value to extract data from.
	 * @param pretty - if the json-string should be formatted "prettily".
	 * @return the specified data converted to json-string format.
	 */
	public static <T> String save(T value, boolean pretty) {
		try {
			return (pretty ? GSON : RAW).toJson(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return value.toString();
	}

	/**
	 * Loads the specified instance of the specified class type from a json string.
	 * @param string - the specified json string to parse data from.
	 * @param class - the specified class type to extract to.
	 * @return the newly loaded instance from the specified data.
	 */
	public static <T> T load(String string, Class<T> clazz) {
		try {
			return GSON.fromJson(string, clazz);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static <T> T load(String string, com.google.common.reflect.TypeToken<T> type) {
		return load(string, type.getType());
	}
	
	public static <T> T load(String string, com.google.gson.reflect.TypeToken<T> type) {
		return load(string, type.getType());
	}
	
	public static <T> T load(String string, Type type) {
		try {
			return GSON.fromJson(string, type);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * The gson instance for raw-printing in this JsonIO utility class.
	 */
	private static Gson RAW;
	/**
	 * The gson instance for pretty-printing in this JsonIO utility class.
	 */
	private static Gson GSON;
	/**
	 * The builder instance for this JsonIO utility class.
	 */
	private static GsonBuilder BUILDER;
	
	private static void updateGson() {
		GSON = BUILDER.create();
	}
	
	public static <T> void adapt(Class<T> clazz, TypeAdapter<T> adapter) {
		BUILDER.registerTypeAdapter(clazz, adapter);
		updateGson();
	}

	public static <T> void adapt(Class<T> clazz, CheckedBiConsumer<JsonWriter, T> writer, CheckedFunction<JsonReader, T> reader) {
		adapt(clazz, new TypeAdapter<T>() {
			@Override
			public void write(JsonWriter out, T value) throws IOException {
				try {
					writer.accept(out, value);
				} catch (Throwable e) {
					e.printStackTrace();
				}
			}

			@Override
			public T read(JsonReader in) throws IOException {
				try {
					return reader.apply(in);
				} catch (Throwable e) {
					e.printStackTrace();
					return null;
				}
			}
		});
	}
	
	/**
	 * The static constructor to instantiate the builder instance.
	 */
	static {
		BUILDER = new GsonBuilder();
		BUILDER.disableHtmlEscaping();
		BUILDER.enableComplexMapKeySerialization();
		RAW = BUILDER.create();
		BUILDER.setPrettyPrinting();
		GSON = BUILDER.create();
		
		adapt(Class.class, (out, val) -> {
			out.value("\"" + val.getCanonicalName() + "\"");
			out.flush();
		}, in -> {
			return Class.forName(in.nextString());
		});
		
		adapt(TypeToken.class, (out, val) -> {
			out.value("\"" + val + "\"");
			out.flush();
		}, in -> {
			return TypeToken.of(Class.forName(in.nextString()));
		});
		
		BUILDER.registerTypeAdapter(Box.class, new BoxDeserializer<>());
		updateGson();
	}
	
	public static class BoxDeserializer<T> implements JsonSerializer<Box<T>>, JsonDeserializer<Box<T>> {
		
		@Override
		public Box<T> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
			JsonElement el = json.getAsJsonObject().get("obj");
			T val = context.deserialize(el, ((ParameterizedType) typeOfT).getActualTypeArguments()[0]);
			return Box.of(val);
		}
		
		@Override
		public JsonElement serialize(Box<T> src, Type typeOfSrc, JsonSerializationContext context) {
			final JsonElement el = context.serialize(src.get());
			return el;
		}
		
	}
}
