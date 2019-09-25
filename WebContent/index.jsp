<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<title>购物屋</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Buy_shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- Custom Theme files -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<script src="js/simpleCart.min.js"> </script>
<!-- Custom Theme files -->
<!--webfont-->
<link href='http://fonts.googleapis.com/css?family=Lato:100,200,300,400,500,600,700,800,900' rel='stylesheet' type='text/css'>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
</head>
<body>
<div class="header_top">
	<div class="container">
		<div class="one-fifth column row_1">
			<span class="selection-box"><select class="domains valid" name="domains">
			   <option>中文</option>
		       <option>英语</option>
		       <option>法语</option>
		       <option>德语</option>
		    </select></span>
         </div>
         <div class="cssmenu">
			<ul>
			    <li class="active"><a href="login.jsp">
			    	<c:if test="${empty user}">
			    		登陆
			    	</c:if>
			    	<c:if test="${not empty user}">
			    		欢迎您:${user.uname}
			    	</c:if>
			    </a></li> 
			</ul>
		 </div>
	</div>
</div>	
<div class="wrap-box"></div>
<div class="header_bottom">
	    <div class="container">
			<div class="col-xs-8 header-bottom-left">
				<div class="col-xs-2 logo">
					<h1><a href="index.jsp"><span>我的</span>小店</a></h1>
				</div>
				<div class="col-xs-6 menu">
		            <ul class="megamenu skyblue">
				      <li  class="active grid"><a  class="color1" onclick="getGoodsByPage(${mentype.ttname})">男士</a>
				      <div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
									<ul>
									<c:forEach var="mentype" items="${Mentypes}" varStatus="status">
									<span style="display:none" id="my_ttname">${mentype.ttname}</span>
										<li><a  id="ttname" onclick="getGoodsByPage()"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" class="tgoods">${mentype.ttname}</font></font></a></li>
										</c:forEach>
									</ul>	
								</div>							
							</div>
						  </div>
						</div>
					</li>
				    <li  class="grid"><a  class="color2" onclick="getSexGoods('女士')">女士</a>
					  <div class="megapanel">
						<div class="row">
							<div class="col1">
								<div class="h_nav">
								<ul>
										<c:forEach var="womentype" items="${Womentypes}" varStatus="status">
										<li><a  onclick="togoods(${womentype.ttname},${womentype.tno})"><font style="vertical-align: inherit;"><font style="vertical-align: inherit;" class="tgoods">${womentype.ttname}</font></font></a></li>
										</c:forEach>
									</ul>
								</div>							
							</div>
							
							
						  </div>
						</div>
			    </li>
				<li><a class="color4" href="about.html">关于</a></li>				
				<li><a class="color5" href="404.html">博客</a></li>
				<li><a class="color6" href="contact.html">支持</a></li>
			  </ul> 
			</div>
		</div>
	    <div class="col-xs-4 header-bottom-right">
	       <div class="box_1-cart">
		     <div class="box_11"><a href="checkout.jsp">
		      <c:if test="${empty user}">
		      <h4><p>购物车: 
		      			    				    	
		      	<span>￥0</span> (<span>0</span> 件)</p><img src="images/bag.png" alt=""/><div class="clearfix"> </div></h4>
		      </c:if>
		      <c:if test="${not empty user}">
		        <h4><p>购物车: 
			    <span>￥${totalprice}</span> (<span">${carsize}</span> 件)</p><img src="images/bag.png" alt=""/><div class="clearfix"> </div></h4>

			  </c:if>
		      </a></div>
	          
	          <div class="clearfix"> </div>
	        </div>
	        
	         <div class="clearfix"></div>
       </div>
        <div class="clearfix"></div>
	 </div>
</div>
<div class="banner">
	<div class="container">
		<div class="banner_desc">
			<h1>新季到来</h1>
			<h2>查看所有新趋势</h2>
			<div class="button">
			      <a class="hvr-shutter-out-horizontal" onclick="getAllGoods()">现在去购物</a>
			    </div>
		</div>
	</div>
</div>	
<div class="content_top">
	<h3 class="m_1">最新产品</h3>
	<div class="container">
	   <div class="box_1">
	       <div class="col-md-7">
			    <div class="section group">
						<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
							<div class="shop-holder">
		                         <div class="product-img">
		                            <a href="single.jsp">
		                                <img width="225" height="265" src="images/pic1.jpg" class="img-responsive"  alt="item4">		                            </a>
		                            <a href="" class="button item_add"></a>		                         </div>
		                    </div>
		                    <div class="shop-content" style="height: 80px;">
		                            <div><a href="single.jsp" rel="tag">幽默</a></div>
		                            <h3><a href="single.jsp">非-特征</a></h3>
		                            <span class="amount item_price">$45.00</span>
		                    </div>
						</div>
						<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
							<div class="shop-holder">
		                         <div class="product-img">
		                            <a href="single.jsp">
		                                <img width="225" height="265" src="images/pic2.jpg" class="img-responsive"  alt="item4">		                            </a>
		                            <a href="" class="button item_add"></a>		                         </div>
		                    </div>
		                    <div class="shop-content" style="height: 80px;">
		                            <div><a href="single.jsp" rel="tag">幽默</a></div>
		                            <h3><a href="single.jsp">非-特征</a></h3>
		                            <span class="amount item_price">$45.00</span>
		                    </div>
						</div>
						<div class="col_1_of_3 span_1_of_3 simpleCart_shelfItem">
							<div class="shop-holder">
		                         <div class="product-img">
		                            <a href="single.jsp">
		                                <img width="225" height="265" src="images/pic3.jpg" class="img-responsive"  alt="item4">		                            </a>
		                           <a href="" class="button item_add"></a>	                         </div>
		                    </div>
		                    <div class="shop-content" style="height: 80px;">
		                            <div><a href="single.jsp" rel="tag">幽默</a></div>
		                            <h3><a href="single.jsp">非-特征</a></h3>
		                            <span class="amount item_price">$45.00</span>
		                    </div>
						</div>
						<div class="clearfix"></div> 
				</div>
		</div>
		<div class="col-md-5 row_3">
			<div class="about-block-content">
		       <div class="border-add"></div>
				<h4>关于我们</h4>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Obcaecati beatae quam voluptatibus deleniti ipsa consequatur!</p>
				<p>Lorem ipsum dolor sit amet, consectetur adipisicing.</p>
				<p>		        	</p></div>
				<img src="images/pic9.jpg" class="img-responsive" alt=""/>
	    </div>
		<div class="clearfix"></div>
	</div>
</div>
</div>
<div class="content_bottom">
<div class="container">
	<h2 class="m_3">来自博客</h2>
	<div class="grid_1">
		<div class="col-md-6 blog_1"><a href="index_single.jsp">
			<div class="item-inner"> 
				<img src="images/pic7.jpg" class="img-responsive" alt=""/>																	
					<div class="date-comments">
						<div class="time"><span class="date"><span class="word1">14</span> <span class="word2">一月</span> </span></div>											 
						<div class="comments">
						<span><span class="word1">0</span>
						<span class="word2">评论</span></span>
						</div>
					 </div>
			</div>   
		</a></div>
		<div class="col-md-6 row_2"><a href="index_single.jsp">
			<div class="item-inner"> 
				<img src="images/pic8.jpg" class="img-responsive" alt=""/>																	
					<div class="date-comments">
						<div class="time"><span class="date"><span class="word1">14</span> <span class="word2">一月</span> </span></div>											 
						<div class="comments">
						<span><span class="word1">0</span>
						<span class="word2">评论</span></span>
						</div>
					 </div>
			</div>   
	    </a></div>
		<div class="clearfix"></div>
	</div>
</div>	
</div>
<div class="content_bottom-grid">
	<div class="col-md-6 row_4"></div>
	 <div class="col-md-6">
		
	</div>
	<div class="clearfix"> </div>
</div>
<div class="footer">
	<div class="container">
	   <div class="footer_top">
		<div class="col-md-4 box_3">
			<h3>我们的商店</h3>
			<address class="address">
              <p>9870 St Vincent Place, <br>Glasgow, DC 45 Fr 45.</p>
              <dl>
                 <dt></dt>
                 <dd>免费电话:<span> +1 800 254 2478</span></dd>
                 <dd>电话:<span> +1 800 547 5478</span></dd>
                 <dd>传真: <span>+1 800 658 5784</span></dd>
                 <dd>邮件:&nbsp; <a href="mailto@example.com">info(at)buyshop.com</a></dd>
              </dl>
           </address>
           <ul class="footer_social">
			  <li><a href=""> <i class="fb"> </i> </a></li>
			  <li><a href=""><i class="tw"> </i> </a></li>
			  <li><a href=""><i class="google"> </i> </a></li>
			  <li><a href=""><i class="instagram"> </i> </a></li>
		   </ul>
		</div>
		<div class="col-md-4 box_3">
			<h3>博客帖子</h3>
			<h4><a href="#">Sed ut perspiciatis unde omnis</a></h4>
			<p>自16世纪以来使用的标准大块Lorem Ipsum被复制</p>
			<h4><a href="#">Sed ut perspiciatis unde omnis</a></h4>
			<p>自16世纪以来使用的标准大块Lorem Ipsum被复制</p>
			<h4><a href="#">Sed ut perspiciatis unde omnis</a></h4>
			<p>自16世纪以来使用的标准大块Lorem Ipsum被复制</p>
		</div>
		<div class="col-md-4 box_3">
			<h3>支持</h3>
			<ul class="list_1">
				<li><a href="#">条款和条件</a></li>
				<li><a href="#">常问问题</a></li>
				<li><a href="#">付款</a></li>
				<li><a href="#">退款</a></li>
				<li><a href="#">跟踪订单</a></li>
				<li><a href="#">服务</a></li>
			</ul>
			<ul class="list_1">
				<li><a href="#">服务</a></li>
				<li><a href="#">按</a></li>
				<li><a href="#">博客</a></li>
				<li><a href="#">关于我们</a></li>
				<li><a href="#">联系我们</a></li>
			</ul>
			<div class="clearfix"> </div>
		</div>
		<div class="clearfix"> </div>
		</div>
		<div class="footer_bottom">
			<div class="copy">
                <p>版权所有© 2015 Buy_shop. All Rights Reserved.<a href="http://w3layouts.com/" target="_blank">版权所有</a> </p>
	        </div>
	    </div>
	</div>
</div>
<script>
	function togoods(ttname){
		
		$.post("/shopping/goodsServlet",{
			op:'togoods',
			ttname:ttname,
			
		},function(data){
			
			location.href="men.jsp";
		});
	}
	
	function getAllGoods(){
		
		$.post("/shopping/goodsServlet",{
			op:'getAllGoods',
			tname:tname
		},function(data){
			
			location.href="men.jsp";
		});
	}
function getSexGoods(tname){
		
		$.post("/shopping/goodsServlet",{
			op:'getSexGoods',
			tname:tname,
			tno:tno,
			ttno:ttno,
			page:1
		},function(data){
			location.href="men.jsp";
		});
	}

function getGoodsByPage(){
	var ttname=$("#my_ttname").html();
	$.post("/shopping/goodsServlet",{
		op:'getGoodsByPage',
		count:7,
		page:1,
		ttname:ttname
	},function(data){
		 if(data>0){
			location.href="men.jsp";
		}
	})
}
</script>

</body>
</html>		