package cl.subtel.utilities;

import java.util.stream.Stream;

public final class StringTool {
	
	 public final static String appender(String... text) {
		StringBuilder builder = new StringBuilder();
		Stream.of(text).forEach(builder::append);
		return builder.toString();
	}

}
