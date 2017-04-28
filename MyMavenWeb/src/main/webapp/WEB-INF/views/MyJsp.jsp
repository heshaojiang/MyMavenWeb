<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/views/common/common.jsp"%>
  <body>
    <table class="table">
	  <caption>基本的表格布局</caption>
	  <thead>
	    <tr>
	      <th>名称</th>
	      <th>城市</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <td>Tanmay</td>
	      <td>Bangalore</td>
	    </tr>
	    <tr>
	      <td>Sachin</td>
	      <td>Mumbai</td>
	    </tr>
	  </tbody>
	</table>
	<form class="form-horizontal" role="form">
	  <div class="form-group">
	    <label for="firstname" class="col-sm-2 control-label">名字</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="firstname" placeholder="请输入名字" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <label for="lastname" class="col-sm-2 control-label">姓</label>
	    <div class="col-sm-10">
	      <input type="text" class="form-control" id="lastname" placeholder="请输入姓" style="width: 300px">
	    </div>
	  </div>
	  <div class="form-group">
	    <div class="col-sm-offset-2 col-sm-10">
	     <button type="button" class="btn btn-primary" 
	    data-toggle="button"> 单个切换
	</button>
	    </div>
	  </div>
	</form>
  </body>
</html>
