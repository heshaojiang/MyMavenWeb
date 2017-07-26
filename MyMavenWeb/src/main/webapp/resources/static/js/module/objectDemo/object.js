/* 方法1 使用对象有属性和方法 */
/* var CheckObject = {
	checkName:function(){
		//验证姓名
		alert("验证姓名");
	},
	checkEmail:function(){
		//验证姓名
		alert("验证邮箱");
	},
	checkPassword:function(){
		//验证密码
		alert("验证密码");
	}
};
CheckObject.checkName(); */

/* 方法2 使用对象,先定义对象，再设置属性和方法  */
/*var CheckObject = {};
CheckObject.checkName=function(){
	//验证姓名
	alert("验证姓名");
};
CheckObject.checkEmail=function(){
	//验证姓名
	alert("验证邮箱");
};
CheckObject.checkPassword=function(){
	//验证密码
	alert("验证密码");
};
CheckObject.checkPassword(); */

/* 方法3 使用类，添加成员方法的方式 */
/*var CheckObject = function(){
	this.checkName = function(){
		//验证姓名
		alert("验证姓名");
	};
	this.checkEmail = function(){
		//验证姓名
		alert("验证邮箱");
	};
	this.checkPassword = function(){
		//验证密码
		alert("验证密码");
	};
};

var a = new CheckObject();
a.checkEmail();*/

var CheckObject = function(){};
CheckObject.prototype = {
	checkName:function(){
		//验证姓名
		alert("验证姓名");
		return this;
	},
	checkEmail:function(){
		//验证姓名
		alert("验证邮箱");
		return this;
	},
	checkPassword:function(){
		//验证密码
		alert("验证密码");
		return this;
	}	
};
var a = new CheckObject();
//a.checkEmail().checkName();



var Book = function(id,name,price){
	var num = 1;
	function checkId(){
		
	};
	this.getName = function(){};
	this.getName = function(){};
};

//继承

function SupClass(name,fn){
	this.name = name;
	this.fn = fn;
	this.getName = function(){
		return this.name;
	};
	this.run = function(){
		fn();
	};
}
SupClass.prototype.toString = function(){
	return this.name+"";
};

function SubClass(name,fn){
	SupClass.call(this, name,fn);
}
SubClass.prototype = new SupClass();
var sub1 = new SubClass("小明",function(){alert("hello");});
console.log(sub1.toString());

function test(){
	function test1(name){
		this.name = name;
	};
	(function(){
		var m = "ss";
		alert(m);
		return new test1(m);
	});
}
test();

console.log(new Object().__proto__);

console.log(Object.prototype);


//简单工厂模式
/*function createPop(type,text){
	var o = new Object();
	o.content = text;
	o.show = function(){
		o.name(text);
	};
	if(type == 'alert'){
		o.name = (function(text){
			alert(text);
		});
		
	}
	if(type == 'prompt'){
		o.name = (function(text){
			prompt(text);
		});
		
	}
	if(type == 'confirm'){
		o.name = (function(text){
			confirm(text);
		});
		
	}
	return o;
}

var a = createPop("confirm", "dsfdfsd");
a.show();*/

//工厂方法模式
/*var Factory = function(type,content){
	if(this instanceof Factory){
		var s = this[type](content);
		console.log(s);
		return s;
	}
	else{
		return new Factory(type,content);
	}
};
Factory.prototype = {
		Java : function(content){
			alert("Java="+content);
			return this;
		},
		JavaScript : function(content){
			alert("JavaScript="+content);
			return this;
		},
		UI : function(content){
			alert("UI="+content);
			return this;
		}
};
var m = new Factory("Java","hello");
m.Java("1");*/

//抽象工厂模式
var Car = function(){};
Car.prototype = {
		getPrice : function(){
			return new Error('抽象方法不能调用');
		},
		getSpeed : function(){
			return new Error('抽象方法不能调用');
		}
};
var info = new Car();
var test = info.getPrice();
console.log(test);
info.getSpeed();


