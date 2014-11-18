<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container">
	<div class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="<spring:url value="/main" htmlEscape="true"/>"><spring:message code="label.title" /><img alt="" src="/SADiploma/resources/favicon.ico"></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class=""><a
						href="<spring:url value="/observer" htmlEscape="true"/>"><spring:message code="label.observer" /></a></li>
					<li class=""><a
						href="<spring:url value="/experimenter" htmlEscape="true"/>"><spring:message code="label.experimenter" /></a></li>
				</ul>
				<div style="float: right;">
					<a href="?language=en">English</a> &nbsp;&nbsp;&nbsp; <a href="?language=uk">Українська</a>
				</div>
			</div>
		</div>
	</div>
</div>