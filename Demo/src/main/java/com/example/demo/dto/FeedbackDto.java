package com.example.demo.dto;

import java.util.Map;

public class FeedbackDto {
String reportType;
String creator;
String date;
String exceptionsSe;
String contentException;

public FeedbackDto(String reportType, String creator, String date, String exceptionsSe, String contentException) {
	super();
	this.reportType = reportType;
	this.creator = creator;
	this.date = date;
	this.exceptionsSe = exceptionsSe;
	this.contentException = contentException;
}
public FeedbackDto() {
}
public String getReportType() {
	return reportType;
}
public void setReportType(String reportType) {
	this.reportType = reportType;
}
public String getCreator() {
	return creator;
}
public void setCreator(String creator) {
	this.creator = creator;
}
public String getDate() {
	return date;
}
public void setDate(String date) {
	this.date = date;
}
public String getExceptionsSe() {
	return exceptionsSe;
}
public void setExceptionsSe(String exceptionsSe) {
	this.exceptionsSe = exceptionsSe;
}
public String getContentException() {
	return contentException;
}
public void setContentException(String contentException) {
	this.contentException = contentException;
}
@Override
public String toString() {
	return "FeedbackDto [reportType=" + reportType + ", creator=" + creator + ", date=" + date + ", exceptionsSe="
			+ exceptionsSe + ", contentException=" + contentException + "]";
}


}
