<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta http-equiv="X-UA-Compatible" content="IE=9" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0" />
    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black" />
    <meta name="format-detection" content="telephone=no, email=no" />
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
	<c:set var="ctx" value="${pageContext.request.contextPath}" />
	<c:set var="ctxPort" value="${pageContext.request.serverPort}" />
	<c:set var="ctxIp" value="${pageContext.request.serverName}" />
	<c:set var="stcSrc" value="${ctx }/resources/static" />
	<%@ include file="/WEB-INF/views/common/common_css.jsp"%>
	<%@ include file="/WEB-INF/views/common/common_js_bt.jsp"%>

	<script type="text/javascript">
	//判断对象是否为空
	function isNotEmpty(obj){
	       var flag = true;
	       if( obj=="" || obj==null || obj=="undefined" || typeof(obj) == "undefined"){
	           flag = false;
	       }
	       return flag;
	}
	
	//是否是查看模式
	function isView(operateType,buttonShow){
		if(operateType == 'view'){
			$("input[type='text'], textarea").attr("readonly", "readonly").removeClass("validate[required]");
			$(".star").text("  ");
			if(buttonShow==undefined || !buttonShow){
				$("input[type='button']").hide();
			}
			$("#file_div input").show();
		}
	}
	
	/**
	* 注册分数验证事件
	* $selectedItems 是jQuery对象，表示需要验证的标签元素
	* sign true或者false ，true:表示不能为空，false:表示可以为空，使用时不传该参数也可以
	**/
	function registerPositiveEvent($selectedItems,sign){
		$selectedItems.blur(function(){
			var value = $.trim($(this).val());
			if(validatePositive(value)){
				$(this).addClass("error-field");
			}
			else{
				$(this).removeClass("error-field");
			}
			if(sign && value==""){
				$(this).addClass("error-field");
			}
			
		});
	}
	
	/***
	 * 注册分数验证事件
	 * @param value 输入的分数
	 * @param value1 被比较的分数
	 * @param isRequire 是否不能空
	 * @param isPositive 是否为正数
	 * @returns {Boolean}
	 */
	 
	function validatePositive(value,value1,isRequire,isPositive){
		if(isPositive==undefined){
			isPositive = true;
		}
		else{
			isPositive = false;
		}
		value = $.trim(value);//去掉空格
		var result = true;;
		if(value != ""){
			if(value1=="" ||parseFloat(value1)==0||(!isPositive)){
				if(value.match(/^[+-]?0\.[0-9]+$/) || value.match(/^[+-]?[1-9][0-9]*\.?[0-9]*$/) || value.match(/^[+-]?0$/)){
					result = false;
					//return  false;
				}
				else{
					result = true;
				}
			}
			else{
				if(value.match(/^0\.[0-9]+$/) || value.match(/^[1-9][0-9]*\.?[0-9]*$/) || value.match(/^0$/)){
					result = false;
					//return  false;
				}
				else{
					result = true;
				}
			}
			
		}
		else{
			result = false;
		}
		if(!result){
			if(value1!=undefined && value1 != null && value1 !=""){
				if(parseFloat(value)>parseFloat(value1)){
					result = true;
				}
			}
			if(isRequire != undefined && isRequire){
				if($.trim(value)==""){
					result = true;
				}
			}
		}
		return result;
	}
	</script>

</head>