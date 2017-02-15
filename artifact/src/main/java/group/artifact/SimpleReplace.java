package group.artifact;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleReplace implements Replace {

	private String from;

	/* (non-Javadoc)
	 * @see group.artifact.IReplace#getFrom()
	 */
	public String getFrom() {
		return from;
	}

	/* (non-Javadoc)
	 * @see group.artifact.IReplace#setFrom(java.lang.String)
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/* (non-Javadoc)
	 * @see group.artifact.IReplace#getTo()
	 */
	public String getTo() {
		return to;
	}

	/* (non-Javadoc)
	 * @see group.artifact.IReplace#setTo(java.lang.String)
	 */
	public void setTo(String to) {
		this.to = to;
	}

	private String to;

	/* (non-Javadoc)
	 * @see group.artifact.IReplace#replace(java.lang.String)
	 */
	public String replace(String in) {
		String out = in;
		Pattern fromPattern = Pattern.compile(getFrom());
		Matcher matcher = fromPattern.matcher(in);
		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {
			//System.out.print(matcher.start() +"-" + matcher.end() + " Matcher:" + matcher.group());
			matcher.appendReplacement(sb, getTo());
		}
		matcher.appendTail(sb);
		out = sb.toString();
		return out;
	}

}
