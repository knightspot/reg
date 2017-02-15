package group.artifact;

public interface Replace {

	String getFrom();

	void setFrom(String from);

	String getTo();

	void setTo(String to);

	String replace(String in);

}