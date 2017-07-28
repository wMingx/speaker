/*!
 * classie - class helper functions
 * from bonzo https://github.com/ded/bonzo
 * 
 * classie.has( elem, 'my-class' ) -> true/false
 * classie.add( elem, 'my-new-class' )
 * classie.remove( elem, 'my-unwanted-class' )
 * classie.toggle( elem, 'my-class' )
 */

/*jshint browser: true, strict: true, undef: true */ 
/*global define: false */

( function( window ) {
 
'use strict';

// class helper functions from bonzo https://github.com/ded/bonzo

function classReg( className ) {
  return new RegExp("(^|\\s+)" + className + "(\\s+|$)");
}

// classList support for class management
// altho to be fair, the api sucks because it won't accept multiple classes at once
var hasClass, addClass, removeClass;

if ( 'classList' in document.documentElement ) {
  hasClass = function( elem, c ) {
    return elem.classList.contains( c );
  };
  addClass = function( elem, c ) {
    elem.classList.add( c );
  };
  removeClass = function( elem, c ) {
    elem.classList.remove( c );
  };
}
else {
  hasClass = function( elem, c ) {
    return classReg( c ).test( elem.className );
  };
  addClass = function( elem, c ) {
    if ( !hasClass( elem, c ) ) {
      elem.className = elem.className + ' ' + c;
    }
  };
  removeClass = function( elem, c ) {
    elem.className = elem.className.replace( classReg( c ), ' ' );
  };                      
}

function toggleClass( elem, c ) {
  var fn = hasClass( elem, c ) ? removeClass : addClass;
  fn( elem, c );
}

var classie = {
  // full names
  hasClass: hasClass,
  addClass: addClass,
  removeClass: removeClass,
  toggleClass: toggleClass,
  // short names
  has: hasClass,
  add: addClass,
  remove: removeClass,
  toggle: toggleClass
};

// transport
if ( typeof define === 'function' && define.amd ) {
  // AMD
  define( classie );
} else {
  // browser global
  window.classie = classie;
}

})( window );



function showLoading()
{
    document.getElementById("over").style.display = "block";
    document.getElementById("layout").style.display = "block";
}
function showend()
{
    document.getElementById("over").style.display = "none";
    document.getElementById("layout").style.display = "none";
}






var xmlhttp; 
function mmyclick()
{  
  
 inputname=document.getElementById("input-4").value;
 inputpass=document.getElementById("input-5").value;
  showLoading();
  
  if (inputname == "") 
  {
      showend();
	alert('账号不能为空，请输入', '错误', function() {
	    document.getElementById("input-4").focus();							
			     });
	return false;
  }
				
  if(inputpass == "") 
  {
       showend();
	 alert('密码不能为空，请输入', '错误', function() {
		 document.getElementById("input-5").focus();
					});
					return false;
  }
	

   loadXMLDoc("manager/userlogin/selsctuserlogin",function()
   {
     if (xmlhttp.readyState==4 && xmlhttp.status==200)
       {
         document.getElementById("text-10").value=xmlhttp.responseText;
    
         var myobj=eval(xmlhttp.responseText);  
       try{
            if(myobj[0].userName!=null)
    	     {
				//	alert("ok");
			// document.getElementById('html1').src = "search2.html"
                showend();	
				
                window.location.href="search.html";
              }else{
                   showend();
                  	alert("账号或密码错误");
              }   
          }catch(err)
          { showend();
              	alert("账号或密码错误");
          }     
       }else{
      //document.getElementById("text-10").value=xmlhttp.status;
       }
   });
}


var inputname;
var inputpass;


function mmybuttomclick1()
{ 
	//alert("ok"+inputname);
	//searchload();
	
	//clearCookie("timeout") ;
	searching();
 }



//相应回车事件  
function testEnterload(evt){
     evt = (evt) ? evt : ((window.event) ? window.event : "") //兼容IE和Firefox获得keyBoardEvent对象  
    var key = evt.keyCode?evt.keyCode:evt.which; //兼容IE和Firefox获得keyBoardEvent对象的键值  

    if(key==13) {  
        mmyclick();  
        return false;  
    }  
}



function testEnter(evt){
     evt = (evt) ? evt : ((window.event) ? window.event : "") //兼容IE和Firefox获得keyBoardEvent对象  
    var key = evt.keyCode?evt.keyCode:evt.which; //兼容IE和Firefox获得keyBoardEvent对象的键值    
    if(key==13) {  
        searching();  
        return false;  
    }  
}

/////////////search page load/////////////////////////

var select;

function searchload()
{
	 var timestamp3 = new Date().getTime(); 
	 var person="userName=1"+"&t="+timestamp3;
        page=1;//分页页码
        pagecount=15;//分页每页数量
 
  
        pagepcb=1;//pcb分页页码
        pagecountpcb=15;//pcb分页每页数量
	
	xmlhttp=null;
	
	postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
	{			
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{						
			var myobj=eval(xmlhttp.responseText);  
		try{
							
			if(myobj[0].userName!=null)
			{				
			//	window.location.href="search.html";    				
			}
			else{			
			alert("登录失效 重新登录");
			window.location.href="index.html";  
			return;
			}			
		 }catch(err)
		 {
			 alert("登录失效 重新登录");
			 window.location.href="index.html";  
			 return;
		 }		
		}
	});
 }
 var searchvalue;
 
 var page=1;//分页页码
 var pagecount=15;//分页每页数量
 var pageall;
  
 var pagepcb=1;//pcb分页页码
 var pagecountpcb=15;//pcb分页每页数量
 var pageallpcb;
 
 
 function postloop(params,machie) {
     
     var person=params;   
     
     
     
     $.post("manager/deliverytable/selectdeliverytablestandard",
    person,
    function(data,status){
        var succ=status;
        if(succ=="success")
        {
         var myobjmidht=new Array();
            
            myobjmidht=data;
            for(var i=0;i<machie.length;i++)
            {
                var  thls=document.getElementById("machineCode"+i.toString());    
                for(var ny=0;ny<myobjmidht.length;ny++)
                {                                                                                    
                    if(thls.innerHTML==myobjmidht[ny].machineCode)
                    {
                        var  thcontractNumber=document.getElementById("contractNumber"+i.toString());  
                        
                        if(thcontractNumber.innerHTML=="null")
                        {
                        thcontractNumber.innerHTML=myobjmidht[ny].contractNumber;
                        }else
                        {
                            
                            thcontractNumber.innerHTML=thcontractNumber.innerHTML+"<br>"+myobjmidht[ny].contractNumber;
                        }
                        
                        var  thcustomerName=document.getElementById("customerName"+i.toString());  
                         
                         if(thcustomerName.innerHTML=="null")
                        {
                        thcustomerName.innerHTML=myobjmidht[ny].customerName;
                        }else
                        {
                            
                            thcustomerName.innerHTML=thcustomerName.innerHTML+"<br>"+myobjmidht[ny].customerName;
                        }
                        
                        var  thdeliveryTime=document.getElementById("deliveryTime"+i.toString());
                         
                         if(thdeliveryTime.innerHTML=="null")
                        {
                        thdeliveryTime.innerHTML=myobjmidht[ny].deliveryTime;
                        }else
                        {
                            
                            thdeliveryTime.innerHTML=thdeliveryTime.innerHTML+"<br>"+myobjmidht[ny].deliveryTime;
                        }
                        
                        
                    }
                }
            }
        
        }
        
        
       /// alert("Data: " + data + "\nStatus: " + status);
    });
     
  /*  postloadXMLDoc("manager/deliverytable/selectdeliverytablestandard",person,function()			
    {
        
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {
            var myobjmidht=new Array();
            
                myobjmidht=eval(xmlhttp.responseText);
            
            for(var i=0;i<machie.length;i++)
            {
                var  thls=document.getElementById("machineCode"+i.toString());    
                for(var ny=0;ny<myobjmidht.length;ny++)
                {                                                                                    
                    if(thls.innerHTML==myobjmidht[ny].machineCode)
                    {
                        var  thcontractNumber=document.getElementById("contractNumber"+i.toString());  
                        
                        
                        thcontractNumber.innerHTML=myobjmidht[ny].contractNumber;
                        
                    }
                }
            }
                                                                        
            
            
            /*   if(myobjmidht.length!=0)
                {  
                for(var i=0;i<myobjmidht.length;i++)
                {
                th.innerHTML=myobjmidht[i].contractNumber;
                tr.appendChild(th);
                }
                }else{
                    th.innerHTML="null";
                    tr.appendChild(th);                                                                                
                }                                                                                                                                                  
                                                                                        
            
            var table01=document.getElementById("table01")
            table01.insertBefore(tr,table01.childNodes[1+locint]);
                
            locint++;  */
                
     //   }
        
  //  });

     
     
 }
 
 
 
 
/*--查询页查询--*/
function searching()
{	
    
    showLoading();
    
	 var searchstring=document.getElementById("search").value;	
	 searchstring = searchstring.replace(/\s/g, "");
     searchvalue=searchstring;
	 if(searchstring!="")
	 {
        page=1;//分页页码
        pagecount=15;//分页每页数量
 
  
        pagepcb=1;//pcb分页页码
        pagecountpcb=15;//pcb分页每页数量
        
		 var timestamp3 = new Date().getTime(); 
		 var person="userName=1"+"&t="+timestamp3;
		
		 var bool=new Boolean;
		     bool=false;
			xmlhttp=null;
			postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
			{			
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{			
					var myobj=eval(xmlhttp.responseText);  
				try{						
						if(myobj[0].userName!=null)
						{
							bool = true;
							if(bool==true)
							{
								/*--开始查询整机--*/								
								var machineModel="1900-01-01 00:00:00"
								var time=getNowFormatDate();
									person="machineCode="+searchstring
								+"&t="+timestamp3
								+"&machineModel="+machineModel
                                +"&page="+page
                                +"&pagecount="+pagecount
								+"&time="+time;
									
									xmlhttp=null;
									postloadXMLDoc("manager/machinecodemodel/selectmachinecodemodelapp",person,function()			
									{			
										if (xmlhttp.readyState==4 && xmlhttp.status==200)
										{			
											var myobj=eval(xmlhttp.responseText);  
										try{
											var myobjmid=new Array();
											
											/*--开始查询单板--*/								
											machineModel="1900-01-01 00:00:00"
											time=getNowFormatDate();
											person="machineCode="+searchstring
											+"&t="+timestamp3
											+"&machineModel="+machineModel
                                            +"&page="+pagepcb
                                            +"&pagecount="+pagecountpcb                                            
											+"&time="+time;
									
											xmlhttp=null;
											postloadXMLDoc("manager/machinecodemodel/selectpcbcodemodelapp",person,function()			
											{			
												if (xmlhttp.readyState==4 && xmlhttp.status==200)
												{				
													var myobjPCB=eval(xmlhttp.responseText);  
													
													//var myobjmid=new Array();		
                                                    var myobjcount=myobj.pop();
                                                    var myobjPCBcount=myobjPCB.pop();
                                                    	//myobjmid.pop;
                                                        	
											
													if(myobj.length!=0||myobjPCB.length!=0)
													{/*--开始制表--*/
														myobjmid=myobj;
														machie=myobj;
														var myobjlen =myobjmid.length;
														
														var Div=document.getElementById("div1");
														Div.innerHTML="";
														var Div2=document.getElementById("div2");
														Div2.innerHTML="";
														var table=document.createElement("table");
														table.width="100%";
														table. border="0" ;
														table.cellspacing="0" ;												
														table.align="center";												
														table.border="1" ;
														table.bordercolor="#C0C0C0";
                                                        table.id="table01";
														//table.style="font-size: 11pt;"
														
														var tbody=document.createElement("tbody");
														
														/*--表头--*/
														var tr=document.createElement("tr");
                                                            tr.id="tr01";
                                                            
														var th=document.createElement("th");
															th.innerHTML="序号";
															tr.appendChild(th);
															
															th=document.createElement("th");
															th.innerHTML="整机编码";
															tr.appendChild(th);
															
															th=document.createElement("th");
															th.innerHTML="整机机型";
															tr.appendChild(th);
															
                                                            th=document.createElement("th");
															th.innerHTML="合同号";
															tr.appendChild(th);
                                                            
                                                            th=document.createElement("th");
															th.innerHTML="客户名称";
															tr.appendChild(th);
                                                            
                                                            th=document.createElement("th");
															th.innerHTML="发货日期";
															tr.appendChild(th);
                                                            
															th=document.createElement("th");
															th.innerHTML="详细";
															tr.appendChild(th);
															tbody.appendChild(tr);	
                                                            
                                                            if(myobj.length==0)
                                                            {
                                                                    tr=document.createElement("tr");
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    /*for(var i=0;i<5;i++)
                                                                    {
                                                                    th=document.createElement("th");
                                                                        th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                                            
                                                                        tr.appendChild(th);
                                                                    }*/
                                                                    tbody.appendChild(tr);	
                                                                    table.appendChild(tbody);
														            Div.appendChild(table);
                                                            }else
                                                            {   
                                                                for(var i=0;i<myobjlen;i++)
                                                                { 
                                                                    
                                                                    tr=document.createElement("tr");
                                                                    th=document.createElement("th");
                                                                    th.innerHTML=i.toString();
                                                                    
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML=myobj[i].machineCode;
                                                                    th.id="machineCode"+i.toString();
                                                                    tr.appendChild(th);
                                                                    
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML=myobj[i].machineModel;
                                                                    tr.appendChild(th);   
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    th.id="contractNumber"+i.toString();
                                                                    tr.appendChild(th);  
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    th.id="customerName"+i.toString();
                                                                    tr.appendChild(th); 
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    th.id="deliveryTime"+i.toString();
                                                                    tr.appendChild(th); 
                                                                    
                                                                    
                                                                    
                                                                   // var locint=0;
                                                                  //var locint=i;
                                                                    /*--开始合同号--*/								
                                                                   // machineModel="1900-01-01 00:00:00"
                                                                   //// time=getNowFormatDate();
                                                                  var  person2="machineCode="+myobj[i].machineCode
                                                                    +"&t="+timestamp3;
                                                                   // +"&machineModel="+machineModel
                                                                   // +"&page="+pagepcb
                                                                   // +"&pagecount="+pagecountpcb                                            
                                                                   /* +"&time="+time*/
                                                                /*  $.ajax({ 
                                                                        type : "post",
                                                                        url : "manager/deliverytable/selectdeliverytablestandard",
                                                                        data : "machineCode="+myobj[i].machineCode+"&t="+timestamp3,
                                                                        async : ture,
                                                                        success : function(data){ 
                                                                            data = eval("(" + data + ")"); 
                                                                            aDataSet = data;                                                                             
                                                                            
                                                                            var  thls=document.getElementById("machineCode"+i.toString());    
                                                                                for(var ny=0;ny<myobjmidht.length;ny++)
                                                                                {                                                                                    
                                                                                    if(thls.innerHTML==myobjmidht[ny].machineCode)
                                                                                    {
                                                                                    var  thcontractNumber=document.getElementById("contractNumber"+i.toString());  
                                                                                    
                                                                                    
                                                                                        thcontractNumber.innerHTML=myobjmidht[ny].contractNumber;
                                                                                        
                                                                                    }
                                                                                
                                                                            } 
                                                                          } 
                                                                        });*/
                                                                   // xmlhttp=null;
                                                                   
                                                                   
                                                                   
                                                                   postloop(person2,machie) ;
                                                                  /*  postloadXMLDoc("manager/deliverytable/selectdeliverytablestandard","machineCode="+myobj[i].machineCode +"&t="+timestamp3,function()			
                                                                    {
                                                                        
                                                                        if (xmlhttp.readyState==4 && xmlhttp.status==200)
                                                                        {
                                                                            var myobjmidht=new Array();
                                                                            
                                                                             myobjmidht=eval(xmlhttp.responseText);
                                                                            
                                                                            for(var i=0;i<machie.length;i++)
                                                                            {
                                                                              var  thls=document.getElementById("machineCode"+i.toString());    
                                                                                for(var ny=0;ny<myobjmidht.length;ny++)
                                                                                {                                                                                    
                                                                                    if(thls.innerHTML==myobjmidht[ny].machineCode)
                                                                                    {
                                                                                       var  thcontractNumber=document.getElementById("contractNumber"+i.toString());  
                                                                                       
                                                                                      
                                                                                        thcontractNumber.innerHTML=myobjmidht[ny].contractNumber;
                                                                                        
                                                                                    }
                                                                                }
                                                                            }*/
                                                                                                                                        
                                                                            
                                                                            
                                                                          /*   if(myobjmidht.length!=0)
                                                                             {  
                                                                                for(var i=0;i<myobjmidht.length;i++)
                                                                                {
                                                                                th.innerHTML=myobjmidht[i].contractNumber;
                                                                                tr.appendChild(th);
                                                                                }
                                                                             }else{
                                                                                 th.innerHTML="null";
                                                                                 tr.appendChild(th);                                                                                
                                                                             }                                                                                                                                                  
                                                                                                                                                      
                                                                           
                                                                            var table01=document.getElementById("table01")
                                                                            table01.insertBefore(tr,table01.childNodes[1+locint]);
                                                                             
                                                                           locint++;  */
                                                                             
                                                                    /*    }
                                                                        
                                                                    });*/
                                                                    
                                                                   	   
                                                                     th=document.createElement("th");
                                                                     th.id="butxx"+i.toString();
                                                                     th.innerHTML="<input type='button' name='详细' value='详细'"+
                                                                    "id="+i+" onclick='tablebuttomclick(this)' >";
                                                                    tr.appendChild(th);                                                              
                                                                   
                                                                    tbody.appendChild(tr);
                                                                   	
                                                                   
                                                                }
                                                                var divpage=document.createElement("div");
                                                                divpage.innerHTML="<input  type='button' onclick='pagecountchangeup(this)' value='上一页'/><label><input id='te4' type='text'>/"+ Math.ceil(myobjcount.machineCode/pagecount)+ "<input  type='button' onclick='pagecountchangedown(this)' value='下一页'/></label><br></br><br></br>"
                                                                                                                            
                                                                table.appendChild(tbody);
                                                              
													            Div.appendChild(table);
                                                              
                                                              //  var body1=document.getElementById("body1");
                                                                Div.appendChild(divpage);
                                                             
                                                                document.getElementById("te4").value=page.toString(); 
                                                                pageall=Math.ceil(myobjcount.machineCode/pagecount);
                                                            }														
																										
													
																
														
														/*--开始制表pcb--*/
														myobjmid=myobjPCB;
														//machiePCBtest=myobjPCB;
														 myobjlen =myobjmid.length;
														
														var Div3=document.getElementById("div3");
														Div3.innerHTML="";
														
													  var  table2=document.createElement("table");
														table2.width="100%";
														table2. border="0" ;
														table2.cellspacing="0" ;												
														table2.align="center";												
														table2.border="1" ;
														table2.bordercolor="#C0C0C0";
														//table.style="font-size: 11pt;"
														
														 tbody=document.createElement("tbody");
														
														/*--表头--*/
														 tr=document.createElement("tr");
														 th=document.createElement("th");
															th.innerHTML="序号";
															tr.appendChild(th);
															
															th=document.createElement("th");
															th.innerHTML="单板编码";
															tr.appendChild(th);
															
															th=document.createElement("th");
															th.innerHTML="单板型号";
															tr.appendChild(th);
															
															th=document.createElement("th");
															th.innerHTML="详细";
															tr.appendChild(th);
															tbody.appendChild(tr);															
														
														
														machiePCBtest=new Array();
                                                        if(myobjPCB.length==0)
                                                        {
                                                                tr=document.createElement("tr");
                                                                th=document.createElement("th");
                                                                th.innerHTML="null";
                                                                tr.appendChild(th);

                                                                th=document.createElement("th");
                                                                th.innerHTML="null";
                                                                // var pcbName = new Array();
                                                                // map.put("pcbName", myobjPCB[i].machineCode);

                                                                // pcbName.push(myobjPCB[i].machineCode);
                                                                tr.appendChild(th);

                                                                th=document.createElement("th");
                                                                th.innerHTML="null";
                                                                tr.appendChild(th);

                                                                th=document.createElement("th");
                                                                th.innerHTML="null";
                                                                tr.appendChild(th);

                                                                /*for(var i=0;i<5;i++)
                                                                {
                                                                th=document.createElement("th");
                                                                    th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                                        
                                                                    tr.appendChild(th);
                                                                }*/
                                                                tbody.appendChild(tr);
                                                                table2.appendChild(tbody);
														        Div3.appendChild(table2);
                                                        }else
                                                        {
                                                            for(var i=0;i<myobjlen;i++)
                                                            {
                                                                tr=document.createElement("tr");
                                                                th=document.createElement("th");
                                                                th.innerHTML=i.toString();
                                                                tr.appendChild(th);
                                                                
                                                                th=document.createElement("th");
                                                                th.innerHTML=myobjPCB[i].machineCode;
                                                                // var pcbName = new Array();
                                                                // map.put("pcbName", myobjPCB[i].machineCode);
                                                                                                                                
                                                                // pcbName.push(myobjPCB[i].machineCode);
                                                                tr.appendChild(th);
                                                                
                                                                th=document.createElement("th");
                                                                th.innerHTML=myobjPCB[i].machineModel;
                                                                tr.appendChild(th);
                                                                
                                                                th=document.createElement("th");
                                                                th.innerHTML="<input type='button' name='单板详细' value='详细'"+
                                                                "id= "+i+" onclick='pagechange(this)' >";
                                                                tr.appendChild(th);
                                                                                                                            
                                                             /*   var buttonpagepcbup=document.createElement("input");
                                                                var buttonpagepcbdown=document.createElement("input");
                                                                var labelpage=document.createElement("label");*/
                                                                                                                                                                                                   
                                                                /*for(var i=0;i<5;i++)
                                                                {
                                                                th=document.createElement("th");
                                                                    th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                                        
                                                                    tr.appendChild(th);
                                                                }*/
                                                                tbody.appendChild(tr);	
                                                               // tbody.appendChild(divpagepcb);	
                                                                machiePCBtest.push({pcbName:myobjPCB[i].machineCode,pcbModel:myobjPCB[i].machineModel});
                                                                
                                                                //machiePCBtest[i].pcbName=pcbName;                                                               
                                                                
                                                            }
                                                            var divpagepcb=document.createElement("div");
                                                                divpagepcb.innerHTML="<input  type='button' onclick='pagecountchangeuppcb(this)' value='上一页'/><label><input id='te5' type='text'>/"+ Math.ceil(myobjPCBcount.machineCode/pagecountpcb) + "<input  type='button' onclick='pagecountchangedownpcb(this)' value='下一页'/></label>"
                                                                                                                    
                                                            
                                                            table2.appendChild(tbody);
                                                            Div3.appendChild(table2);
                                                           // body1=document.getElementById("body1");
                                                            Div3.appendChild(divpagepcb);                                                          
                                                            document.getElementById("te5").value=pagepcb.toString(); 
                                                            pageallpcb=Math.ceil(myobjPCBcount.machineCode/pagecountpcb);
                                                        }
													// body1.appendChild(table);	
                                                     showend();	
													}else{
													    showend();
														alert("查询为空");
														//window.location.href="index.html";  
														//return;
													}													
												}
											});											
										}catch(err)
										{	showend();	
											alert("查询不到该信息");
											//window.location.href="index.html";  
											//return;	 
										}							
									}
								});				
										
								
								
							}							
						}else{			
                             showend();			
							alert("登录过期 重新登录");
							window.location.href="index.html";  
							return false;
						}						
					}catch(err)
					{	showend();
						alert("登录过期 重新登录");
						window.location.href="index.html";  
						return false;		 
					}
				}
			});		 		
	 }else{
          showend();
		 alert("输入不可为空"); 
	 }
     
     	
 }


/*--分页控制--*/
function pagecountchangeup(x)
{
  var page2=document.getElementById("te4").value;
  if(page!=page2)
  {
    if(page2<1||page2>pageall)
    {
        alert("超出范围");
        
    }else
    {
        page=page2;
       pagecountchange();
        
    }
  }else
  {
      page2--;
      if(page2<1||page2>pageall)
    {
        alert("超出范围");
        
    }else
    {
       page--;
       pagecountchange();
        
    }
      
  } 
}

function pagecountchangedown()
{
     var page2=document.getElementById("te4").value;
  if(page!=page2)
  {
    if(page2<1||page2>pageall)
    {
        alert("超出范围");
        
    }else
    {
         page=page2;
       pagecountchange();
        
    }
  }else
  {
      page2++;
      if(page2<1||page2>pageall)
    {
        alert("超出范围");
        
    }else
    {
       page++;
       pagecountchange();
        
    }
      
  }
    
}

function pagecountchange(x)
{
    if(searchvalue!="")
	 {
         showLoading();
         
		 var timestamp3 = new Date().getTime(); 
		 var person="userName=1"+"&t="+timestamp3;
		
		 var bool=new Boolean;
		     bool=false;
			xmlhttp=null;
			postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
			{			
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{			
					var myobj=eval(xmlhttp.responseText);  
				try{						
						if(myobj[0].userName!=null)
						{
							bool = true;
							if(bool==true)
							{
								/*--开始查询整机--*/								
								var machineModel="1900-01-01 00:00:00"
								var time=getNowFormatDate();
									person="machineCode="+searchvalue
								+"&t="+timestamp3
								+"&machineModel="+machineModel
                                +"&page="+page
                                +"&pagecount="+pagecount
								+"&time="+time;
									
									xmlhttp=null;
									postloadXMLDoc("manager/machinecodemodel/selectmachinecodemodelapp",person,function()			
									{			
										if (xmlhttp.readyState==4 && xmlhttp.status==200)
										{			
											var myobj=eval(xmlhttp.responseText);  
										try{
											var myobjmid=new Array();											
											var myobjcount=myobj.pop();
													if(myobj.length!=0)
													{/*--开始制表--*/
														myobjmid=myobj;
														machie=myobj;
														var myobjlen =myobjmid.length;
														
														var Div=document.getElementById("div1");
														Div.innerHTML="";
														var Div2=document.getElementById("div2");
														Div2.innerHTML="";
														var table=document.createElement("table");
														table.width="100%";
														table. border="0" ;
														table.cellspacing="0" ;												
														table.align="center";												
														table.border="1" ;
														table.bordercolor="#C0C0C0";
														//table.style="font-size: 11pt;"
														
														var tbody=document.createElement("tbody");
														
														/*--表头--*/
														var tr=document.createElement("tr");
														var th=document.createElement("th");
															th.innerHTML="序号";
															tr.appendChild(th);
															
															th=document.createElement("th");
															th.innerHTML="整机编码";
															tr.appendChild(th);
															
															th=document.createElement("th");
															th.innerHTML="整机机型";
															tr.appendChild(th);
                                                            
                                                            th=document.createElement("th");
															th.innerHTML="合同号";
															tr.appendChild(th);
                                                            
                                                            th=document.createElement("th");
															th.innerHTML="客户名称";
															tr.appendChild(th);
                                                            
                                                            th=document.createElement("th");
															th.innerHTML="发货日期";
															tr.appendChild(th);
															
															th=document.createElement("th");
															th.innerHTML="详细";
															tr.appendChild(th);
															tbody.appendChild(tr);	
                                                            
                                                            if(myobj.length==0)
                                                            {
                                                                    tr=document.createElement("tr");
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    tr.appendChild(th);
                                                                    
                                                                    /*for(var i=0;i<5;i++)
                                                                    {
                                                                    th=document.createElement("th");
                                                                        th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                                            
                                                                        tr.appendChild(th);
                                                                    }*/
                                                                    tbody.appendChild(tr);	
                                                                    table.appendChild(tbody);
														            Div.appendChild(table);
                                                            }else
                                                            {
                                                                for(var i=0;i<myobjlen;i++)
                                                                {
                                                                    tr=document.createElement("tr");
                                                                    th=document.createElement("th");
                                                                    th.innerHTML=i.toString();
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML=myobj[i].machineCode;
                                                                    th.id="machineCode"+i.toString();
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML=myobj[i].machineModel;
                                                                    tr.appendChild(th);
                                                                    
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    th.id="contractNumber"+i.toString();
                                                                    tr.appendChild(th);  
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    th.id="customerName"+i.toString();
                                                                    tr.appendChild(th); 
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="null";
                                                                    th.id="deliveryTime"+i.toString();
                                                                    tr.appendChild(th); 
                                                                    
                                                                     var  person2="machineCode="+myobj[i].machineCode
                                                                    +"&t="+timestamp3;
                                                                    postloop(person2,machie) ;
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="<input type='button' name='详细' value='详细'"+
                                                                    "id="+i+" onclick='tablebuttomclick(this)' >";
                                                                    tr.appendChild(th);                                                                    
                                                                   
                                                                    tbody.appendChild(tr);	                                                                   
                                                                }
                                                                var divpage=document.createElement("div");
                                                                divpage.innerHTML="<input  type='button' onclick='pagecountchangeup(this)' value='上一页'/><label><input id='te4' type='text'>/"+ Math.ceil(myobjcount.machineCode/pagecount) + "<input  type='button' onclick='pagecountchangedown(this)' value='下一页'/></label><br></br><br></br>"
                                                                                                                            
                                                                table.appendChild(tbody);
                                                              
													            Div.appendChild(table);
                                                              
                                                              //  var body1=document.getElementById("body1");
                                                                Div.appendChild(divpage);
                                                             
                                                                document.getElementById("te4").value=page.toString(); 
                                                                pageall=Math.ceil(myobjcount.machineCode/pagecount)  ;
                                                            }
													    showend();	
                                                       }else{
													 showend();
														alert("查询为空");
														//window.location.href="index.html";  
														//return;
													   }
                                                       
                                            }catch(err)                                                       
                                            {		 showend();	
                                                alert("查询不到该信息");
                                                //window.location.href="index.html";  
                                                //return;	 
										    }							
									}
								});				
										
							}							
						}else{		
                             showend();				
							alert("登录过期 重新登录");
							window.location.href="index.html";  
							return false;
						}						
					}catch(err)
					{			 showend();
						alert("登录过期 重新登录");
						window.location.href="index.html";  
						return false;		 
					}
				}
			});		 		
	 }else{
		 alert("输入不可为空"); 
	 }                       								
	
}



function pagecountchangeuppcb(x)
{
     var page2=document.getElementById("te5").value;
  if(pagepcb!=page2)
  {
    if(page2<1||page2>pageallpcb)
    {
        alert("超出范围");
        
    }else
    {
       pagepcb=page2;
       pagecountchangepcb();
        
    }
  }else
  {
      page2--;
      if(page2<1||page2>pageallpcb)
    {
        alert("超出范围");
        
    }else
    {
       pagepcb=page2;
       pagecountchangepcb();
        
    }
      
  }
}


function pagecountchangedownpcb(x)
{
      var page2=document.getElementById("te5").value;
  if(pagepcb!=page2)
  {
    if(page2<1||page2>pageallpcb)
    {
        alert("超出范围");
        
    }else
    {
       pagepcb=page2;
       pagecountchangepcb();
        
    }
  }else
  {
      page2++;
      if(page2<1||page2>pageallpcb)
    {
        alert("超出范围");
        
    }else
    {
       pagepcb=page2;
       pagecountchangepcb();
        
    }
      
  }
}

function pagecountchangepcb()
{
   if(searchvalue!="")
	 {  
          showLoading();
        
		 var timestamp3 = new Date().getTime(); 
		 var person="userName=1"+"&t="+timestamp3;
		
		 var bool=new Boolean;
		     bool=false;
			xmlhttp=null;
			postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
			{			
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{			
					var myobj=eval(xmlhttp.responseText);  
				try{						
						if(myobj[0].userName!=null)
						{
							bool = true;
							if(bool==true)
							{
								 /*--开始查询单板--*/								
                              var  machineModel="1900-01-01 00:00:00"
                              var  time=getNowFormatDate();
                                person="machineCode="+searchvalue
                                +"&t="+timestamp3
                                +"&machineModel="+machineModel
                                +"&page="+pagepcb
                                +"&pagecount="+pagecountpcb                                            
                                +"&time="+time;
                        
                                xmlhttp=null;
                                postloadXMLDoc("manager/machinecodemodel/selectpcbcodemodelapp",person,function()			
                                {			
                                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                                    {				
                                        var myobjPCB=eval(xmlhttp.responseText);  
                                        
                                        //var myobjmid=new Array();		
                                      
                                        var myobjPCBcount=myobjPCB.pop();
                                        //myobjmid.pop;                                               
                                
                                      if(myobjPCB.length!=0)
                                        {
                                            
                                            var Div2=document.getElementById("div2");
                                            Div2.innerHTML="";
                                            
                                            
                                            var tbody=document.createElement("tbody");
                                            
                                            /*--表头--*/
                                            var tr=document.createElement("tr");
                                            var th=document.createElement("th");
                                            
                                            
                                            /*--开始制表pcb--*/
                                        
                                            //machiePCBtest=myobjPCB;
                                           var  myobjlen =myobjPCB.length;
                                            
                                            var Div3=document.getElementById("div3");
                                            Div3.innerHTML="";
                                            
                                            var  table2=document.createElement("table");
                                            table2.width="100%";
                                            table2. border="0" ;
                                            table2.cellspacing="0" ;												
                                            table2.align="center";												
                                            table2.border="1" ;
                                            table2.bordercolor="#C0C0C0";
                                            //table.style="font-size: 11pt;"                
                                              
                                            
                                           
                                             
                                                th.innerHTML="序号";
                                                tr.appendChild(th);
                                                
                                                th=document.createElement("th");
                                                th.innerHTML="单板编码";
                                                tr.appendChild(th);
                                                
                                                th=document.createElement("th");
                                                th.innerHTML="单板型号";
                                                tr.appendChild(th);
                                                
                                                th=document.createElement("th");
                                                th.innerHTML="详细";
                                                tr.appendChild(th);
                                                tbody.appendChild(tr);															
                                            
                                            
                                            machiePCBtest=new Array();
                                            if(myobjPCB.length==0)
                                            {
                                                    tr=document.createElement("tr");
                                                    th=document.createElement("th");
                                                    th.innerHTML="null";
                                                    tr.appendChild(th);

                                                    th=document.createElement("th");
                                                    th.innerHTML="null";
                                                    // var pcbName = new Array();
                                                    // map.put("pcbName", myobjPCB[i].machineCode);

                                                    // pcbName.push(myobjPCB[i].machineCode);
                                                    tr.appendChild(th);

                                                    th=document.createElement("th");
                                                    th.innerHTML="null";
                                                    tr.appendChild(th);

                                                    th=document.createElement("th");
                                                    th.innerHTML="null";
                                                    tr.appendChild(th);

                                                    /*for(var i=0;i<5;i++)
                                                    {
                                                    th=document.createElement("th");
                                                        th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                            
                                                        tr.appendChild(th);
                                                    }*/
                                                    tbody.appendChild(tr);
                                                    table2.appendChild(tbody);
                                                    Div3.appendChild(table2);
                                            }else
                                            {
                                                for(var i=0;i<myobjlen;i++)
                                                {
                                                    tr=document.createElement("tr");
                                                    th=document.createElement("th");
                                                    th.innerHTML=i.toString();
                                                    tr.appendChild(th);
                                                    
                                                    th=document.createElement("th");
                                                    th.innerHTML=myobjPCB[i].machineCode;
                                                    // var pcbName = new Array();
                                                    // map.put("pcbName", myobjPCB[i].machineCode);
                                                                                                                    
                                                    // pcbName.push(myobjPCB[i].machineCode);
                                                    tr.appendChild(th);
                                                    
                                                    th=document.createElement("th");
                                                    th.innerHTML=myobjPCB[i].machineModel;
                                                    tr.appendChild(th);
                                                    
                                                    th=document.createElement("th");
                                                    th.innerHTML="<input type='button' name='单板详细' value='详细'"+
                                                    "id= "+i+" onclick='pagechange(this)' >";
                                                    tr.appendChild(th);
                                                                                                                
                                                    /*   var buttonpagepcbup=document.createElement("input");
                                                    var buttonpagepcbdown=document.createElement("input");
                                                    var labelpage=document.createElement("label");*/
                                                                                                                                                                                        
                                                    /*for(var i=0;i<5;i++)
                                                    {
                                                    th=document.createElement("th");
                                                        th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                            
                                                        tr.appendChild(th);
                                                    }*/
                                                    tbody.appendChild(tr);	
                                                    // tbody.appendChild(divpagepcb);	
                                                    machiePCBtest.push({pcbName:myobjPCB[i].machineCode,pcbModel:myobjPCB[i].machineModel});
                                                   // machiePCBtest.push({pcbModel:myobjPCB[i].machineModel});
                                                    //machiePCBtest[i].pcbName=pcbName;                                                               
                                                    
                                                }
                                                var divpagepcb=document.createElement("div");
                                                    divpagepcb.innerHTML="<input  type='button' onclick='pagecountchangeuppcb(this)' value='上一页'/><label><input id='te5' type='text'>/"+ Math.ceil(myobjPCBcount.machineCode/pagecountpcb) + "<input  type='button' onclick='pagecountchangedownpcb(this)' value='下一页'/></label>"
                                                                                                        
                                                
                                                table2.appendChild(tbody);
                                                Div3.appendChild(table2);
                                                // body1=document.getElementById("body1");
                                                Div3.appendChild(divpagepcb);                                                          
                                                document.getElementById("te5").value=pagepcb.toString(); 
                                                pageallpcb=Math.ceil(myobjPCBcount.machineCode/pagecountpcb)  ;
                                            }
                                        // body1.appendChild(table);	
                                         showend();	
                                        
                                        }else{
                                         showend();
                                            alert("查询为空");
                                            //window.location.href="index.html";  
                                            //return;
                                        }	
                                        												
                                    }
                                });					
										
							}							
						}else{			
                             showend();			
							alert("登录过期 重新登录");
							window.location.href="index.html";  
							return false;
						}						
					}catch(err)
					{			 showend();
						alert("登录过期 重新登录");
						window.location.href="index.html";  
						return false;		 
					}
				}
			});		 		
	 }else{
          showend();
		 alert("输入不可为空"); 
	 }
    
    	
    
}






/*--首页跳转判断--*/
var pageid;
function pagechange(x)
{
    pageid=x.id;
     select=2;
    tablePCBbuttomtestclick(x);
}


/*--table点击详细--*/
var machie=new Array();//编码
var onclickid;
 function tablebuttomclick(x)
 {
	  //alert(x.id);
      select=1;
	  var Div2=document.getElementById("div2");
	  Div2.innerHTML="";
	  onclickid=x.id;
	  var searchstring=machie[x.id].machineCode;
	 searchstring = searchstring.replace(/\s/g, "");
     
     
  /*--新页面打开--*/   
        var url = "search2.html"; 
        
        
        window.open(encodeURI(url + "?searchstring=" + searchstring+"&select="+ select 
        +"&machineCode="+machie[x.id].machineCode+"&machineModel="+machie[x.id].machineModel
        +"&onclickid="+onclickid));

        //encodeURI编码
     
     
  /*---*/   
/*	 if(searchstring!="")
	 {
		 var timestamp3 = new Date().getTime(); 
		 var person="userName=1"+"&t="+timestamp3;
		
		 var bool=new Boolean;
		     bool=false;
			xmlhttp=null;
			postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
			{			
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{			
					var myobj=eval(xmlhttp.responseText);  
				try{						
						if(myobj[0].userName!=null)
						{
							bool = true;
							if(bool==true)
							{
								/*--开始查询--*/								
								
/*									person="machineCode="+searchstring+"&t="+timestamp3;
									
									xmlhttp=null;
									/*--装配信息--*/
/*									postloadXMLDoc("manager/assemblytable/selectassemblytable",person,function()			
									{			
										if (xmlhttp.readyState==4 && xmlhttp.status==200)
										{			
											var ass=eval(xmlhttp.responseText);  					
											
											/*--测试信息--*/
/*												person="code="+searchstring
													+"&t="+timestamp3;
									
												xmlhttp=null;
												
												postloadXMLDoc("manager/testrecord/selscttestrecord",person,function()			
												{			
													if (xmlhttp.readyState==4 && xmlhttp.status==200)
													{			
														var test=eval(xmlhttp.responseText); 		
														
														/*--出货信息--*/														
/*															person="machineCode="+searchstring
														+"&t="+timestamp3;
													
											
														xmlhttp=null;
												        postloadXMLDoc("manager/deliverytable/selectdeliverytablestandard",person,function()			
														{			
															if (xmlhttp.readyState==4 && xmlhttp.status==200)
															{			
																var deli=eval(xmlhttp.responseText); 
																
																try{																
																	
																	if(ass.length!=0||test.length !=0||deli.length!=0)
																	{/*--开始制表--*/
																	 																															
/*																		var myobjlen =ass.length+test.length+deli.length;
																		
																		var Div=document.getElementById("div1");
																		Div.innerHTML="";
																		var Div3=document.getElementById("div3");
	 																	Div3.innerHTML="";
																		
																		var table=document.createElement("table");
																		table.width="100%";
																		table. border="0" ;
																		table.cellspacing="0" ;												
																		table.align="center";												
																		table.border="1" ;
																		table.bordercolor="#C0C0C0";
																		//table.style="font-size: 11pt;"
																		
																		var tbody=document.createElement("tbody");
																		tbody.align="center";
																		/*--表头--*/
/*																		var tr=document.createElement("tr");
																		tr.align="center";
																		var th=document.createElement("th");
																			th.align="center";
																			th.innerHTML="整机编码";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.align="center";
																			th.innerHTML="整机机型";
																			tr.appendChild(th);
																			
																			
																			tbody.appendChild(tr);
																			
																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML=machie[x.id].machineCode;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=machie[x.id].machineModel;
																			tr.appendChild(th);
																			
																			
																			tbody.appendChild(tr);
																			
																			/*--空行--*/
/*																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML="";
																			tr.appendChild(th);															
																			
																			
																			tbody.appendChild(tr);
																		
																		/*--装配表头--*/
																		/**
																		*  @装配信息表 assembly_table
																		*  @整机编码 		machineCode		String
																			@整机机型		machineModel	String
																			@单板编码		pcbName	String
																			@单板型号		pcbModel	String
																			@装配人员		assemblyName	String
																			@装配人员编码	assemblyCode	String
																			@装配日期		deliveryTime	datatime
																			@备注			assemblyNote	String
																			@创建时间		createdTime	datatime
																			@更新时间		updatedTime	datatime*/
/*																			machiePCBtest=ass;
																			
																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML="装配的单板编码";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="装配的单板型号";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="装配人员";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="装配日期";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="装配备注";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="测试详细";
																			tr.appendChild(th);
																			
																			
																			tbody.appendChild(tr);																			
																			
																			
																		
																		for(var i=0;i<ass.length;i++)
																		{
																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML=ass[i].pcbName;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=ass[i].pcbModel;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=ass[i].assemblyName;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=ass[i].deliveryTime;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=ass[i].assemblyNote;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="<input type='button' name='单板测试详细' value='单板测试详细'"+
																			"id="+i+" onclick='tablePCBbuttomtestclick(this)' >";
																			tr.appendChild(th);
																			
																			/*for(var i=0;i<5;i++)
																			{
																			th=document.createElement("th");
																				th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
																					
																				tr.appendChild(th);
																			}*/
/*																			tbody.appendChild(tr);	
																		}		
																		
																		/*--空行--*/
/*																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML=" ";
																			tr.appendChild(th);															
																			
																			
																			tbody.appendChild(tr);
																		
																		
																		/*--测试表头--*/
																		/**  @测试记录表 test_record
																	    	@型号编码 	code	String
																			@型号 	    model	String
																			@测试人员   testName	String
																			@测试日期	 testTime	datatime
																			@测试结果   testResults	String
																			@旧时间标示   oldtesttime	String*/
/*																			machietest=test;
																		
																		 	tr=document.createElement("tr");
																		 	th=document.createElement("th");
																			th.innerHTML="测试人员";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="测试日期";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="测试用例";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="测试结果";
																			tr.appendChild(th);
																			tbody.appendChild(tr);																			
																			
																			
																		
																		for(var i=0;i<test.length;i++)
																		{
																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML=test[i].testName;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=test[i].testTime;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=test[i].model;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=test[i].testResults;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="<input type='button' name='测试详细' value='测试详细'"+
																			"id="+i+" onclick='tablebuttomtestclick(this)' >";
																			tr.appendChild(th);
																		
																			/*for(var i=0;i<5;i++)
																			{
																			th=document.createElement("th");
																				th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
																					
																				tr.appendChild(th);
																			}*/
/*																			tbody.appendChild(tr);	
																		}
																		/*--空行--*/
/*																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML=" ";
																			tr.appendChild(th);															
																			
																			
																			tbody.appendChild(tr);		
																			
																		/*--出货表头--*/
																		/**
																		*  @库查询表   delivery_table
																		*	@整机编码 	machineCode		String
																		*	@整机机型 	machineModel	String
																		*	@客户名称		customerName	String
																		*	@合同号 		contractNumber	String
																		*	@发货地址		deliveryAddress	String
																		*	@发货日期		deliveryTime	datatime////
																		*	@发货人		consignor		String
																		*	@发货备注		deliveryNote	String
																		*	@创建时间		createdTime		datatime////
																		*	@更新时间		updatedTime		datatime////
																		*	@序号			intflag        int																		/
																		
																		**/	
/*																		    tr=document.createElement("tr");
																		    th=document.createElement("th");
																			th.innerHTML="客户名称";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="合同号";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="发货地址";
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML="发货日期";
																			tr.appendChild(th);
																			tbody.appendChild(tr);	
																			
																			th=document.createElement("th");
																			th.innerHTML="发货人";
																			tr.appendChild(th);
																			tbody.appendChild(tr);				
																			
																			th=document.createElement("th");
																			th.innerHTML="发货备注";
																			tr.appendChild(th);
																			tbody.appendChild(tr);														
																			
																			
																		
																		for(var i=0;i<deli.length;i++)
																		{
																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML=deli[i].customerName;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=deli[i].contractNumber;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=deli[i].deliveryAddress;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=deli[i].deliveryTime;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=deli[i].consignor;
																			tr.appendChild(th);
																			
																			th=document.createElement("th");
																			th.innerHTML=deli[i].deliveryNote;
																			tr.appendChild(th);
																			
																			/*for(var i=0;i<5;i++)
																			{
																			th=document.createElement("th");
																				th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
																					
																				tr.appendChild(th);
																			}*/
/*																			tbody.appendChild(tr);	
																		}
																		/*--空行--*/
/*																			tr=document.createElement("tr");
																			th=document.createElement("th");
																			th.innerHTML=" ";
																			tr.appendChild(th);		
																			tbody.appendChild(tr);													
																	
																	
																		table.appendChild(tbody);
																		Div.appendChild(table);		
																	// body1.appendChild(table);		
																	}else{
																	
																		alert("查询为空");
																		//window.location.href="index.html";  
																		//return;
																	}											
																}catch(err)
																{			
																	alert("查询不到该信息");
																	//window.location.href="index.html";  
																	//return;	 
																}															
															}
														});
													}
												});
												
									}
								});
							}							
						}else{						
							alert("登录过期 重新登录");
							window.location.href="index.html";  
							return false;
						}						
					}catch(err)
					{			
						alert("登录过期 重新登录");
						window.location.href="index.html";  
						return false;		 
					}
				}
			});		 		
	 }else{
		 alert("输入不可为空");
	 }
*/     
 }
 
  /*--tablePCBtest点击详细--*/
 var machiePCBtest=new Array();//testPCB编码
/***  @装配信息表 assembly_table
*  @整机编码 		machineCode		String
   @整机机型		machineModel	String
@单板编码		pcbName	String
@单板型号		pcbModel	String
@装配人员		assemblyName	String
@装配人员编码	assemblyCode	String
@装配日期		deliveryTime	datatime
@备注			assemblyNote	String
@创建时间		createdTime	datatime
@更新时间		updatedTime	datatime*/
 function tablePCBbuttomtestclick(x)
 {
     select=2;
	 x.id=x.id.replace(/\s/g, "");
	 var searchstring=machiePCBtest[x.id].pcbName;	
	 searchstring = searchstring.replace(/\s/g, "");
     
     
      /*--新页面打开--*/   
        var url = "search2.html";
                 
        window.open(encodeURI(url + "?searchstring=" + searchstring+"&select="+ select 
        +"&machiePCBCode="+machiePCBtest[x.id].pcbName+"&machiePCBModel="+machiePCBtest[x.id].pcbModel
        +"&onclickid="+onclickid));
        //encodeURI编码     
     
/*	 var Div2=document.getElementById("div2");
		 Div2.innerHTML="";
	
	 if(searchstring!="")
	 {
		 var timestamp3 = new Date().getTime(); 
		 var person="userName=1"+"&t="+timestamp3;
		
		 var bool=new Boolean;
		     bool=false;
			xmlhttp=null;
			postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
			{			
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{			
					var myobj=eval(xmlhttp.responseText);  
				try{						
						if(myobj[0].userName!=null)
						{
							bool = true;
							if(bool==true)
							{
								/*--开始查询--*/								
								
/*										person="code="+searchstring
													+"&t="+timestamp3;
									
									xmlhttp=null;
									postloadXMLDoc("manager/testrecord/selscttestrecord",person,function()			
									{			
										if (xmlhttp.readyState==4 && xmlhttp.status==200)
										{			
											var myobj=eval(xmlhttp.responseText);  
										try{
											var myobjmid=new Array();
											
											
											if(myobj[0].code!=null)
											{/*--开始制表--*/
											
											
											
/*											    var tbody=document.createElement("tbody");	
												myobjmid=myobj;
												
												var myobjlen =myobjmid.length;
												
												var Div=document.getElementById("div1");
												Div.innerHTML="";
												var Div3=document.getElementById("div3");
	 	 										Div3.innerHTML="";
												
												var table=document.createElement("table");
												table.width="100%";
												table. border="0" ;
												table.cellspacing="0" ;												
												table.align="center";												
												table.border="1" ;
												table.bordercolor="#C0C0C0";
												//table.style="font-size: 11pt;"
												
													/*--表头--*/
/*                                          var tr=document.createElement("tr");
                                            tr.align="center";
                                            var th=document.createElement("th");
                                                th.align="center";
                                                th.innerHTML="单板编码";
                                                tr.appendChild(th);
                                                
                                                th=document.createElement("th");
                                                th.align="center";
                                                th.innerHTML="单板型号";
                                                tr.appendChild(th);
                                                
                                                
                                                tbody.appendChild(tr);
                                                
                                                tr=document.createElement("tr");
                                                th=document.createElement("th");
                                                th.innerHTML=machiePCBtest[x.id].pcbName;
                                                tr.appendChild(th);
                                                
                                                th=document.createElement("th");
                                                th.innerHTML=machiePCBtest[x.id].pcbModel;
                                                tr.appendChild(th);
                                                
                                                
                                                tbody.appendChild(tr);
                                                
                                                /*--空行--*/
/*                                              tr=document.createElement("tr");
                                                th=document.createElement("th");
                                                th.innerHTML="";
                                                tr.appendChild(th);															
                                                
                                                
                                                tbody.appendChild(tr);
                                                
                                                
                                                
                                                
                                                
                                               											
												
												 tr=document.createElement("tr");
												 th=document.createElement("th");
												/**  @测试记录表 test_record
												     @型号编码 	code	String
													@型号 	    model	String
													@测试人员   testName	String
													@测试日期	 testTime	datatime
													@测试结果   testResults	String
													@旧时间标示   oldtesttime	String*/													
/*													machietest=myobjmid;
																
													tr=document.createElement("tr");
													th=document.createElement("th");
												    th.innerHTML="测试人员";
													tr.appendChild(th);
																			
													th=document.createElement("th");
													th.innerHTML="测试日期";
													tr.appendChild(th);
																			
													th=document.createElement("th");
													th.innerHTML="测试用例";
													tr.appendChild(th);
																			
													th=document.createElement("th");
													th.innerHTML="测试结果";
													tr.appendChild(th);
                                                    
                                                    th=document.createElement("th");
                                                    th.innerHTML="详细信息";
                                                    tr.appendChild(th);
                                                    
													tbody.appendChild(tr);																			
																			
																			
																		
													for(var i=0;i<myobjlen;i++)
													{
													    tr=document.createElement("tr");
														th=document.createElement("th");
														th.innerHTML=myobj[i].testName;
														tr.appendChild(th);
																		
														th=document.createElement("th");
														th.innerHTML=myobj[i].testTime;
														tr.appendChild(th);
																			
														th=document.createElement("th");
														th.innerHTML=myobj[i].model;
														tr.appendChild(th);
																			
														th=document.createElement("th");
														th.innerHTML=myobj[i].testResults;
														tr.appendChild(th);
																			
														th=document.createElement("th");
														th.innerHTML="<input type='button' name='测试详细' value='测试详细'"+
																	  "id="+i+" onclick='tablebuttomtestclick(this)' >";
														tr.appendChild(th);
																		
																		
														tbody.appendChild(tr);	
													}													
																											
											
												table.appendChild(tbody);
												Div.appendChild(table);		
											// body1.appendChild(table);		
											}else{
											
												alert("查询为空");
												//window.location.href="index.html";  
												//return;
											}											
										}catch(err)
										{			
											alert("查询不到该信息");
											//window.location.href="index.html";  
											//return;	 
										}									
									}
								});
							}							
						}else{						
							alert("登录过期 重新登录");
							window.location.href="index.html";  
							return false;
						}						
					}catch(err)
					{			
						alert("登录过期 重新登录");
						window.location.href="index.html";  
						return false;		 
					}
				}
			});		 		
	 }else{
		 alert("输入不可为空");
	 }
*/	 
 }
 
 /*--tabletest点击详细--*/
 var machietest=new Array();//test编码
 /**  @测试记录表 test_record
@型号编码 	code	String
@型号 	    model	String																			
@测试人员   testName	String																			
@测试日期	 testTime	datatime																			
@测试结果   testResults	String																			
@旧时间标示   oldtesttime	String*/
 function tablebuttomtestclick(x)
 {
	 var searchstring=machietest[x.id].code;	
	 searchstring = searchstring.replace(/\s/g, "");
     
     
     /*--新页面打开--*/   
        var url = "search3.html";
                 
        window.open(encodeURI(url + "?searchstring=" + searchstring 
        +"&oldtesttime="+machietest[x.id].oldtesttime+"&machieModelcode="+machietest[x.id].code
        +"&machieModelmodel="+machietest[x.id].model));
        //encodeURI编码  
     
     
     
/*	 if(searchstring!="")
	 {
		 var timestamp3 = new Date().getTime(); 
		 var person="userName=1"+"&t="+timestamp3;
		
		 var bool=new Boolean;
		     bool=false;
			xmlhttp=null;
			postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
			{			
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{			
					var myobj=eval(xmlhttp.responseText);  
				try{						
						if(myobj[0].userName!=null)
						{
							bool = true;
							if(bool==true)
							{
								/*--开始查询--*/								
								
/*									person="machineModel="+searchstring
								+"&t="+timestamp3
								+"&testTime="+machietest[x.id].oldtesttime;
									
									xmlhttp=null;
									postloadXMLDoc("manager/machinetestlog/selectmachinetestLog",person,function()			
									{			
										if (xmlhttp.readyState==4 && xmlhttp.status==200)
										{			
											var myobj=eval(xmlhttp.responseText);  
										try{
											var myobjmid=new Array();
											
											
											if(myobj[0].machineModel!=null)
											{/*--开始制表--*/
/*												myobjmid=myobj;
												
												var myobjlen =myobjmid.length;
												
												var Div=document.getElementById("div1");
												Div.innerHTML="";
												
												var table=document.createElement("table");
												table.width="100%";
												table. border="0" ;
												table.cellspacing="0" ;												
												table.align="center";												
												table.border="1" ;
												table.bordercolor="#C0C0C0";
												//table.style="font-size: 11pt;"
												
												var tbody=document.createElement("tbody");
												

													tbody.align="center";
													/*--表头--*/
/*													var tr=document.createElement("tr");
													    tr.align="center";
													var th=document.createElement("th");
														th.align="center";
														th.innerHTML="编码";
														tr.appendChild(th);
																			
														th=document.createElement("th");
														th.align="center";
														th.innerHTML="机型";
														tr.appendChild(th);
																			
																			
														tbody.appendChild(tr);
																			
														tr=document.createElement("tr");
														th=document.createElement("th");
														th.innerHTML=machietest[x.id].code;
														tr.appendChild(th);
														
														th=document.createElement("th");
														th.innerHTML=machietest[x.id].model;
														tr.appendChild(th);
														
														
														tbody.appendChild(tr);
														
														/*--空行--*/
/*														tr=document.createElement("tr");
														th=document.createElement("th");
														th.innerHTML="";
														tr.appendChild(th);															
														
														
														tbody.appendChild(tr);												
												
												/*--表头--*/
												/**         @产品测试记录表 整机测试记录
															@测试编码	    machineModel				String
															@名称	   		machineName				String
															@原始值			originalValue			String
															@系数     		ratio					String
															@数据	        data 					String
															@数据下限		dataMin					String
															@数据上限		dataMax					String
															@故障标示		faultFlag					String
															@测试时间		testTime///旧参数 尽量不使用	String
															@创建时间		createdTime					datatime
												*/
/*												 	tr=document.createElement("tr");
												 	th=document.createElement("th");
													th.innerHTML="名称";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="原始值";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="系数";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="数据";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="数据下限";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="数据上限";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="测试时间";
													tr.appendChild(th);
													
													tbody.appendChild(tr);	
												
												for(var i=0;i<myobjlen;i++)
												{
													tr=document.createElement("tr");
													th=document.createElement("th");
													th.innerHTML=myobj[i].machineName;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].originalValue;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].ratio;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].data;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].dataMin;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].dataMax;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].testTime;
													tr.appendChild(th);
													/*for(var i=0;i<5;i++)
													{
													th=document.createElement("th");
														th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
															
														tr.appendChild(th);
													}*/
/*													tbody.appendChild(tr);	
												}													
											
												table.appendChild(tbody);
												
												Div.appendChild(table);	
											 var Div2=document.getElementById("div2");
											// var buttonback=document.createElement("div");
												 Div2.innerHTML="<input type='button' name='返回' value='返回'"+
																	  "id='goback'  onclick='buttonbackclick(this)' >";
											//	Div2.appendChild(buttonback);		
											  //   body1.appendChild(table);		
											}else{
											
												alert("查询为空");
												//window.location.href="index.html";  
												//return;
											}											
										}catch(err)
										{			
											alert("查询不到该信息");
											//window.location.href="index.html";  
											//return;	 
										}									
									}
								});
							}							
						}else{						
							alert("登录过期 重新登录");
							window.location.href="index.html";  
							return false;
						}						
					}catch(err)
					{			
						alert("登录过期 重新登录");
						window.location.href="index.html";  
						return false;		 
					}
				}
			});		 		
	 }else{
		 alert("输入不可为空");
	 }
*/	 
 }
 
 /*--返回--*/
 function buttonbackclick(x)
 {
     if(select==1)
     {
         x.id=onclickid;
	 var Div2=document.getElementById("div2");
		 Div2.innerHTML="";
	  tablebuttomclick(x);
     }else{
         if(select==2)
            {
                  Div2=document.getElementById("div2");                  
                  Div2.innerHTML="";
                  
                  x.id= pageid;
                  tablePCBbuttomtestclick(x);
                
            }else
            {
                searching();
            }
         
         
     }
 }
 /*--pageload2--*/
 
function searchload2()
{
	 var timestamp3 = new Date().getTime(); 
	 var person="userName=1"+"&t="+timestamp3;
     /*   page=1;//分页页码
        pagecount=15;//分页每页数量
 
  
        pagepcb=1;//pcb分页页码
        pagecountpcb=15;//pcb分页每页数量*/
	
	xmlhttp=null;
	
	postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
	{			
		if (xmlhttp.readyState==4 && xmlhttp.status==200)
		{						
			var myobj=eval(xmlhttp.responseText);  
		try{
							
			if(myobj[0].userName!=null)
			{				
			//	window.location.href="search.html";    	
             // var url = "search2.html"; 
            // var urlinfo = window.location.href;                                                                //获取url
             var searchstring = getURLParameter("searchstring");
             select = getURLParameter("select");
             onclickid=getURLParameter("onclickid");
            
                if(select==1)
                {
                    var tomachineCode=getURLParameter("machineCode");
                    var tomachineModel=getURLParameter("machineModel");
                    if(searchstring!="")
                    {
                    var timestamp3 = new Date().getTime(); 
                    var person="userName=1"+"&t="+timestamp3;
                    
                    var bool=new Boolean;
                        bool=false;
                        xmlhttp=null;
                        postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
                        {			
                            if (xmlhttp.readyState==4 && xmlhttp.status==200)
                            {			
                                var myobj=eval(xmlhttp.responseText);  
                            try{						
                                    if(myobj[0].userName!=null)
                                    {
                                        bool = true;
                                        if(bool==true)
                                        {
                                            /*--开始查询--*/								
                                            
                                                person="machineCode="+searchstring+"&t="+timestamp3;
                                                
                                                xmlhttp=null;
                                                /*--装配信息--*/
                                                postloadXMLDoc("manager/assemblytable/selectassemblytable",person,function()			
                                                {			
                                                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                                                    {			
                                                        var ass=eval(xmlhttp.responseText);  					
                                                        
                                                        /*--测试信息--*/
                                                            person="code="+searchstring
                                                                +"&t="+timestamp3;
                                                
                                                            xmlhttp=null;
                                                            
                                                            postloadXMLDoc("manager/testrecord/selscttestrecord",person,function()			
                                                            {			
                                                                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                                                                {			
                                                                    var test=eval(xmlhttp.responseText); 		
                                                                    
                                                                    /*--出货信息--*/														
                                                                        person="machineCode="+searchstring
                                                                    +"&t="+timestamp3;
                                                                
                                                        
                                                                    xmlhttp=null;
                                                                    postloadXMLDoc("manager/deliverytable/selectdeliverytablestandard",person,function()			
                                                                    {			
                                                                        if (xmlhttp.readyState==4 && xmlhttp.status==200)
                                                                        {			
                                                                            var deli=eval(xmlhttp.responseText); 
                                                                            
                                                                             /*--机型状态--*/														
                                                                                person="machineCode="+searchstring
                                                                                +"&t="+timestamp3;
                                                                            
                                                                            postloadXMLDoc("manager/machineflage/selectMachineFlagemachineCode",person,function()			
                                                                            {			
                                                                                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                                                                                {			
                                                                                    var macflag=eval(xmlhttp.responseText); 
                                                                                    
                                                                                    
                                                                                    try{																
                                                                                        
                                                                                        if(ass.length!=0||test.length !=0||deli.length!=0)
                                                                                        {/*--开始制表--*/
                                                                                                                                                                                                                    
                                                                                            var myobjlen =ass.length+test.length+deli.length;
                                                                                            
                                                                                            var Div=document.getElementById("div1");
                                                                                            Div.innerHTML="";
                                                                                            var Div3=document.getElementById("div3");
                                                                                            Div3.innerHTML="";
                                                                                            
                                                                                            var table=document.createElement("table");
                                                                                            table.width="100%";
                                                                                            table. border="0" ;
                                                                                            table.cellspacing="0" ;												
                                                                                            table.align="center";												
                                                                                            table.border="1" ;
                                                                                            table.bordercolor="#C0C0C0";
                                                                                            //table.style="font-size: 11pt;"
                                                                                            
                                                                                            var tbody=document.createElement("tbody");
                                                                                            tbody.align="center";
                                                                                            /*--表头--*/
                                                                                            var tr=document.createElement("tr");
                                                                                            tr.align="center";
                                                                                            var th=document.createElement("th");
                                                                                                th.align="center";
                                                                                                th.innerHTML="整机编码";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.align="center";
                                                                                                th.innerHTML="整机机型";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.align="center";
                                                                                                th.innerHTML="整机状态";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.align="center";
                                                                                                th.innerHTML="装配检验";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                tbody.appendChild(tr);
                                                                                                
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=tomachineCode;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=tomachineModel;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                if(macflag.length!=0)
                                                                                                {
                                                                                                  th.innerHTML=macflag[0].machineFlag;
                                                                                                }else{
                                                                                                    
                                                                                                    th.innerHTML="null";
                                                                                                }
                                                                                               
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                if(macflag.length!=0)
                                                                                                {
                                                                                                   th.innerHTML=macflag[0].machineModel;
                                                                                                }else{
                                                                                                    
                                                                                                    th.innerHTML="null";
                                                                                                }
                                                                                               
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                tbody.appendChild(tr);
                                                                                                
                                                                                               
                                                                                               
                                                                                               
                                                                                                /*--空行--*/
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="";
                                                                                                tr.appendChild(th);															
                                                                                                
                                                                                                
                                                                                                tbody.appendChild(tr);
                                                                                            
                                                                                            /*--装配表头--*/
                                                                                            /**
                                                                                            *  @装配信息表 assembly_table
                                                                                            *  @整机编码 		machineCode		String
                                                                                                @整机机型		machineModel	String
                                                                                                @单板编码		pcbName	String
                                                                                                @单板型号		pcbModel	String
                                                                                                @装配人员		assemblyName	String
                                                                                                @装配人员编码	assemblyCode	String
                                                                                                @装配日期		deliveryTime	datatime
                                                                                                @备注			assemblyNote	String
                                                                                                @创建时间		createdTime	datatime
                                                                                                @更新时间		updatedTime	datatime*/
                                                                                                machiePCBtest=ass;
                                                                                                
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="装配的单板编码";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="装配的单板型号";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="装配人员";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="装配日期";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="装配备注";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="测试详细";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                
                                                                                                tbody.appendChild(tr);																			
                                                                                                
                                                                                                
                                                                                            
                                                                                            for(var i=0;i<ass.length;i++)
                                                                                            {
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=ass[i].pcbName;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=ass[i].pcbModel;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=ass[i].assemblyName;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=ass[i].deliveryTime;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=ass[i].assemblyNote;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="<input type='button' name='单板测试详细' value='单板测试详细'"+
                                                                                                "id="+i+" onclick='tablePCBbuttomtestclick(this)' >";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                /*for(var i=0;i<5;i++)
                                                                                                {
                                                                                                th=document.createElement("th");
                                                                                                    th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                                                                        
                                                                                                    tr.appendChild(th);
                                                                                                }*/
                                                                                                tbody.appendChild(tr);	
                                                                                            }		
                                                                                            
                                                                                            /*--空行--*/
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=" ";
                                                                                                tr.appendChild(th);															
                                                                                                
                                                                                                
                                                                                                tbody.appendChild(tr);
                                                                                            
                                                                                            
                                                                                            /*--测试表头--*/
                                                                                            /**  @测试记录表 test_record
                                                                                                @型号编码 	code	String
                                                                                                @型号 	    model	String
                                                                                                @测试人员   testName	String
                                                                                                @测试日期	 testTime	datatime
                                                                                                @测试结果   testResults	String
                                                                                                @旧时间标示   oldtesttime	String*/
                                                                                                machietest=test;
                                                                                            
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="测试人员";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="测试日期";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="测试用例";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="测试结果";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="测试信息";
                                                                                                tr.appendChild(th);


                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="<input type='button' name='追加测试详细' value='追加测试详细'"+
                                                                                                "id=addtestbutton"+" onclick='addtestbutton(this)' >";;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                tbody.appendChild(tr);																			
                                                                                                
                                                                                                
                                                                                            
                                                                                            for(var i=0;i<test.length;i++)
                                                                                            {
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=test[i].testName;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=test[i].testTime;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=test[i].model;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                            //  th.innerHTML=test[i].testResults;
                                                                                                if(parseInt(test[i].testResults)==0)
                                                                                                {
                                                                                                    th.bgColor="red";
                                                                                                    th.innerHTML="错误";
                                                                                                    
                                                                                                }else
                                                                                                {
                                                                                                    if(parseInt(test[i].testResults)==1)
                                                                                                    {
                                                                                                    th.innerHTML="正确";
                                                                                                    }else{
                                                                                                    th.innerHTML=test[i].testResults;
                                                                                                    th.bgColor="yellow";
                                                                                                    }
                                                                                                }                                                                                                                                                                                
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="<input type='button' name='测试详细' value='测试详细'"+
                                                                                                "id="+i+" onclick='tablebuttomtestclick(this)' >";
                                                                                                tr.appendChild(th);
                                                                                            
                                                                                                /*for(var i=0;i<5;i++)
                                                                                                {
                                                                                                th=document.createElement("th");
                                                                                                    th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                                                                        
                                                                                                    tr.appendChild(th);
                                                                                                }*/
                                                                                                tbody.appendChild(tr);	
                                                                                            }
                                                                                            /*--空行--*/
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=" ";
                                                                                                tr.appendChild(th);															
                                                                                                
                                                                                                
                                                                                                tbody.appendChild(tr);		
                                                                                                
                                                                                            /*--出货表头--*/
                                                                                            /**
                                                                                            *  @库查询表   delivery_table
                                                                                            *	@整机编码 	machineCode		String
                                                                                            *	@整机机型 	machineModel	String
                                                                                            *	@客户名称		customerName	String
                                                                                            *	@合同号 		contractNumber	String
                                                                                            *	@发货地址		deliveryAddress	String
                                                                                            *	@发货日期		deliveryTime	datatime////
                                                                                            *	@发货人		consignor		String
                                                                                            *	@发货备注		deliveryNote	String
                                                                                            *	@创建时间		createdTime		datatime////
                                                                                            *	@更新时间		updatedTime		datatime////
                                                                                            *	@序号			intflag        int																		/
                                                                                            
                                                                                            **/	
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="客户名称";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="合同号";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="发货地址";
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="发货日期";
                                                                                                tr.appendChild(th);
                                                                                                tbody.appendChild(tr);	
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="发货人";
                                                                                                tr.appendChild(th);
                                                                                                tbody.appendChild(tr);				
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML="发货备注";
                                                                                                tr.appendChild(th);
                                                                                                tbody.appendChild(tr);														
                                                                                                
                                                                                                
                                                                                            
                                                                                            for(var i=0;i<deli.length;i++)
                                                                                            {
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=deli[i].customerName;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=deli[i].contractNumber;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=deli[i].deliveryAddress;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=deli[i].deliveryTime;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=deli[i].consignor;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=deli[i].deliveryNote;
                                                                                                tr.appendChild(th);
                                                                                                
                                                                                                /*for(var i=0;i<5;i++)
                                                                                                {
                                                                                                th=document.createElement("th");
                                                                                                    th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
                                                                                                        
                                                                                                    tr.appendChild(th);
                                                                                                }*/
                                                                                                tbody.appendChild(tr);	
                                                                                            }
                                                                                            /*--空行--*/
                                                                                                tr=document.createElement("tr");
                                                                                                th=document.createElement("th");
                                                                                                th.innerHTML=" ";
                                                                                                tr.appendChild(th);		
                                                                                                tbody.appendChild(tr);													
                                                                                        
                                                                                        
                                                                                            table.appendChild(tbody);
                                                                                            Div.appendChild(table);		
                                                                                        // body1.appendChild(table);		
                                                                                        }else{
                                                                                        
                                                                                            alert("查询为空");
                                                                                            CloseWebPage();
                                                                                            //window.location.href="index.html";  
                                                                                            //return;
                                                                                        }											
                                                                                    }catch(err)
                                                                                    {			
                                                                                        alert("查询不到该信息");
                                                                                        CloseWebPage();
                                                                                        //window.location.href="index.html";  
                                                                                        //return;	 
                                                                                    }	
                                                                                 }
                                                                            });														
                                                                        }
                                                                    });
                                                                }
                                                            });
                                                            
                                                }
                                            });
                                        }							
                                    }else{						
                                        alert("登录过期 重新登录");
                                        window.location.href="index.html";  
                                        return false;
                                    }						
                                }catch(err)
                                {			
                                    alert("登录过期 重新登录");
                                    window.location.href="index.html";  
                                    return false;		 
                                }
                            }
                        });		 		
                    }else{
                        alert("输入不可为空");
                         CloseWebPage();
                    }
                    
                }else
                {
                    var machiePCBCode=getURLParameter("machiePCBCode");
                    var machiePCBModel=getURLParameter("machiePCBModel");
                    if(searchstring!="")
                        {
                             timestamp3 = new Date().getTime(); 
                             person="userName=1"+"&t="+timestamp3;
                            
                             bool=new Boolean;
                                bool=false;
                                xmlhttp=null;
                                postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
                                {			
                                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                                    {			
                                        var myobj=eval(xmlhttp.responseText);  
                                    try{						
                                            if(myobj[0].userName!=null)
                                            {
                                                bool = true;
                                                if(bool==true)
                                                {
                                                    /*--开始查询--*/								
                                                    
                                                            person="code="+searchstring
                                                                        +"&t="+timestamp3;
                                                        
                                                        xmlhttp=null;
                                                        postloadXMLDoc("manager/testrecord/selscttestrecord",person,function()			
                                                        {			
                                                            if (xmlhttp.readyState==4 && xmlhttp.status==200)
                                                            {			
                                                                var myobj=eval(xmlhttp.responseText);  
                                                            try{
                                                                var myobjmid=new Array();
                                                                
                                                                
                                                                if(myobj[0].code!=null)
                                                                {/*--开始制表--*/
                                                                
                                                                
                                                                
                                                                    var tbody=document.createElement("tbody");	
                                                                    myobjmid=myobj;
                                                                    
                                                                    var myobjlen =myobjmid.length;
                                                                    
                                                                    var Div=document.getElementById("div1");
                                                                    Div.innerHTML="";
                                                                    var Div3=document.getElementById("div3");
                                                                    Div3.innerHTML="";
                                                                    
                                                                    var table=document.createElement("table");
                                                                    table.width="100%";
                                                                    table. border="0" ;
                                                                    table.cellspacing="0" ;												
                                                                    table.align="center";												
                                                                    table.border="1" ;
                                                                    table.bordercolor="#C0C0C0";
                                                                    //table.style="font-size: 11pt;"
                                                                    
                                                                        /*--表头--*/
                                                                var tr=document.createElement("tr");
                                                                tr.align="center";
                                                                var th=document.createElement("th");
                                                                    th.align="center";
                                                                    th.innerHTML="单板编码";
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.align="center";
                                                                    th.innerHTML="单板型号";
                                                                    tr.appendChild(th);
                                                                    
                                                                    
                                                                    tbody.appendChild(tr);
                                                                    
                                                                    tr=document.createElement("tr");
                                                                    th=document.createElement("th");
                                                                    th.innerHTML=machiePCBCode;
                                                                    tr.appendChild(th);
                                                                    
                                                                    th=document.createElement("th");
                                                                    th.innerHTML=machiePCBModel;
                                                                    tr.appendChild(th);
                                                                    
                                                                    
                                                                    tbody.appendChild(tr);
                                                                    
                                                                    /*--空行--*/
                                                                    tr=document.createElement("tr");
                                                                    th=document.createElement("th");
                                                                    th.innerHTML="";
                                                                    tr.appendChild(th);															
                                                                    
                                                                    
                                                                    tbody.appendChild(tr);
                                                                    
                                                                    
                                                                    
                                                                    
                                                                    
                                                                                                            
                                                                    
                                                                    tr=document.createElement("tr");
                                                                    th=document.createElement("th");
                                                                    /**  @测试记录表 test_record
                                                                         @型号编码 	code	String
                                                                        @型号 	    model	String
                                                                        @测试人员   testName	String
                                                                        @测试日期	 testTime	datatime
                                                                        @测试结果   testResults	String
                                                                        @旧时间标示   oldtesttime	String*/													
                                                                        machietest=myobjmid;
                                                                                    
                                                                        tr=document.createElement("tr");
                                                                        th=document.createElement("th");
                                                                        th.innerHTML="测试人员";
                                                                        tr.appendChild(th);
                                                                                                
                                                                        th=document.createElement("th");
                                                                        th.innerHTML="录入日期";
                                                                        tr.appendChild(th);
                                                                                                
                                                                        th=document.createElement("th");
                                                                        th.innerHTML="测试用例";
                                                                        tr.appendChild(th);
                                                                                                
                                                                        th=document.createElement("th");
                                                                        th.innerHTML="测试结果";
                                                                        tr.appendChild(th);
                                                                        
                                                                        th=document.createElement("th");
                                                                        th.innerHTML="详细信息";
                                                                        tr.appendChild(th);
                                                                        
                                                                        tbody.appendChild(tr);																			
                                                                                                
                                                                                                
                                                                                            
                                                                        for(var i=0;i<myobjlen;i++)
                                                                        {
                                                                            tr=document.createElement("tr");
                                                                            th=document.createElement("th");
                                                                            th.innerHTML=myobj[i].testName;
                                                                            tr.appendChild(th);
                                                                                            
                                                                            th=document.createElement("th");
                                                                            th.innerHTML=myobj[i].testTime;
                                                                            tr.appendChild(th);
                                                                                                
                                                                            th=document.createElement("th");
                                                                            th.innerHTML=myobj[i].model;
                                                                            tr.appendChild(th);
                                                                                                
                                                                            th=document.createElement("th");
                                                                            
                                                                            if(parseInt(myobj[i].testResults)==0)
                                                                            {
                                                                                th.bgColor="red";
                                                                                th.innerHTML="错误";
                                                                                
                                                                            }else
                                                                            {
                                                                                if(parseInt(myobj[i].testResults)==1)
                                                                                {
                                                                                th.innerHTML="正确";
                                                                                }else{
                                                                                th.innerHTML=myobj[i].testResults;
                                                                                th.bgColor="yellow";
                                                                                }
                                                                            }
                                                                            tr.appendChild(th);
                                                                                                
                                                                            th=document.createElement("th");
                                                                            th.innerHTML="<input type='button' name='测试详细' value='测试详细'"+
                                                                                        "id="+i+" onclick='tablebuttomtestclick(this)' >";
                                                                            tr.appendChild(th);
                                                                                            
                                                                                            
                                                                            tbody.appendChild(tr);	
                                                                        }													
                                                                                                                                
                                                                
                                                                    table.appendChild(tbody);
                                                                    Div.appendChild(table);		
                                                                // body1.appendChild(table);		
                                                                }else{
                                                                
                                                                    alert("查询为空");
                                                                     CloseWebPage();
                                                                    //window.location.href="index.html";  
                                                                    //return;
                                                                }											
                                                            }catch(err)
                                                            {			
                                                                alert("查询不到该信息");
                                                                 CloseWebPage();
                                                                //window.location.href="index.html";  
                                                                //return;	 
                                                            }									
                                                        }
                                                    });
                                                }							
                                            }else{						
                                                alert("登录过期 重新登录");
                                                window.location.href="index.html";  
                                                return false;
                                            }						
                                        }catch(err)
                                        {			
                                            alert("登录过期 重新登录");
                                            window.location.href="index.html";  
                                            return false;		 
                                        }
                                    }
                                });		 		
                        }else{
                            alert("输入不可为空");
                             CloseWebPage();
                        }
                    
                }                   			
			}
			else{			
			alert("登录失效 重新登录");
			window.location.href="index.html";  
			return;
			}			
		 }catch(err)
		 {
			 alert("登录失效 重新登录");
			 window.location.href="index.html";  
			 return;
		 }		
		}
	});
 }


function addtestbutton(x)
{
 /*--新页面打开--*/   
        var url = "testoverset.html"; 
        var tomachineCode=getURLParameter("machineCode");
        var tomachineModel=getURLParameter("machineModel");
        
        window.open(encodeURI(url + "?machineCode="+tomachineCode+"&machineModel="+tomachineModel));

}






 
 /*--pageload3--*/
 
function searchload3()
{
   /* window.open(encodeURI(url + "?searchstring=" + searchstring 
        +"&oldtesttime="+machietest[x.id].oldtesttime+"&machieModelcode="+machietest[x.id].code
        +"&machieModelmodel="+machietest[x.id].model));*/
    
    
    var searchstring=getURLParameter("searchstring");
    var oldtesttime=getURLParameter("oldtesttime");
    var machieModelcode=getURLParameter("machieModelcode");
    var machieModelmodel=getURLParameter("machieModelmodel");
    
    if(searchstring!="")
	 {
		 var timestamp3 = new Date().getTime(); 
		 var person="userName=1"+"&t="+timestamp3;
		
		 var bool=new Boolean;
		     bool=false;
			xmlhttp=null;
			postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
			{			
				if (xmlhttp.readyState==4 && xmlhttp.status==200)
				{			
					var myobj=eval(xmlhttp.responseText);  
				try{						
						if(myobj[0].userName!=null)
						{
							bool = true;
							if(bool==true)
							{
								/*--开始查询--*/								
								
									person="machineModel="+searchstring
								+"&t="+timestamp3
								+"&testTime="+oldtesttime;
									
									xmlhttp=null;
									postloadXMLDoc("manager/machinetestlog/selectmachinetestLog",person,function()			
									{			
										if (xmlhttp.readyState==4 && xmlhttp.status==200)
										{			
											var myobj=eval(xmlhttp.responseText);  
										try{
											var myobjmid=new Array();
											
											
											if(myobj[0].machineModel!=null)
											{/*--开始制表--*/
												myobjmid=myobj;
												
												var myobjlen =myobjmid.length;
												
												var Div=document.getElementById("div1");
												Div.innerHTML="";
												
												var table=document.createElement("table");
												table.width="100%";
												table. border="0" ;
												table.cellspacing="0" ;												
												table.align="center";												
												table.border="1" ;
												table.bordercolor="#C0C0C0";
												//table.style="font-size: 11pt;"
												
												var tbody=document.createElement("tbody");
												

													tbody.align="center";
													/*--表头--*/
													var tr=document.createElement("tr");
													    tr.align="center";
													var th=document.createElement("th");
														th.align="center";
														th.innerHTML="编码";
														tr.appendChild(th);
																			
														th=document.createElement("th");
														th.align="center";
														th.innerHTML="机型";
														tr.appendChild(th);
																			
																			
														tbody.appendChild(tr);
																			
														tr=document.createElement("tr");
														th=document.createElement("th");
														th.innerHTML=machieModelcode;
														tr.appendChild(th);
														
														th=document.createElement("th");
														th.innerHTML=machieModelmodel;
														tr.appendChild(th);
														
														
														tbody.appendChild(tr);
														
														/*--空行--*/
														tr=document.createElement("tr");
														th=document.createElement("th");
														th.innerHTML="";
														tr.appendChild(th);															
														
														
														tbody.appendChild(tr);												
												
												/*--表头--*/
												/**         @产品测试记录表 整机测试记录
															@测试编码	    machineModel				String
															@名称	   		machineName				String
															@原始值			originalValue			String
															@系数     		ratio					String
															@数据	        data 					String
															@数据下限		dataMin					String
															@数据上限		dataMax					String
															@故障标示		faultFlag					String
															@测试时间		testTime///旧参数 尽量不使用	String
															@创建时间		createdTime					datatime
												*/
												 	tr=document.createElement("tr");
												 	th=document.createElement("th");
													th.innerHTML="名称";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="原始值";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="系数";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="数据";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="数据下限";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="数据上限";
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML="测试时间";
													tr.appendChild(th);
													
													tbody.appendChild(tr);	
												
												for(var i=0;i<myobjlen;i++)
												{
													tr=document.createElement("tr");
													th=document.createElement("th");
													th.innerHTML=myobj[i].machineName;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].originalValue;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].ratio;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].data;

                                                    if(!isNaN( parseFloat(myobj[i].data)))
                                                    {
                                                        if(parseFloat(myobj[i].data)>parseFloat(myobj[i].dataMax)||parseFloat(myobj[i].data)<parseFloat(myobj[i].dataMin))
                                                        {
                                                            th.bgColor="red";
                                                        }
                                                    }else{
                                                        if(myobj[i].data=="不合格"||myobj[i].data=="合格")
                                                        {
                                                             if(myobj[i].data=="不合格")
                                                            {
                                                                th.bgColor="red";
                                                            }
                                                        }else{

                                                            th.bgColor="yello";
                                                        }
                                                        



                                                    }
                                                    
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].dataMin;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].dataMax;
													tr.appendChild(th);
													
													th=document.createElement("th");
													th.innerHTML=myobj[i].testTime;
													tr.appendChild(th);
													/*for(var i=0;i<5;i++)
													{
													th=document.createElement("th");
														th.innerHTML="<input type='checkbox' name='ck' value="+i+" />";				
															
														tr.appendChild(th);
													}*/
													tbody.appendChild(tr);	
												}													
											
												table.appendChild(tbody);
												
												Div.appendChild(table);	
											// var Div2=document.getElementById("div2");
											// var buttonback=document.createElement("div");
											/*	 Div2.innerHTML="<input type='button' name='返回' value='返回'"+
																	  "id='goback'  onclick='buttonbackclick(this)' >";*/
											//	Div2.appendChild(buttonback);		
											  //   body1.appendChild(table);		
											}else{
											
												alert("查询为空");
                                                CloseWebPage();
												//window.location.href="index.html";  
												//return;
											}											
										}catch(err)
										{			
											alert("查询不到该信息");
                                             CloseWebPage();
											//window.location.href="index.html";  
											//return;	 
										}									
									}
								});
							}							
						}else{						
							alert("登录过期 重新登录");
							window.location.href="index.html";  
							return false;
						}						
					}catch(err)
					{			
						alert("登录过期 重新登录");
						window.location.href="index.html";  
						return false;		 
					}
				}
			});		 		
	 }else{
		 alert("输入不可为空");
	 }
    
}
 
 /*--如何根据url获取参数：--*/ 
 function getURLParameter(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search)||[,""])[1].replace(/\+/g, '%20'))||null;
}
 
 /*--窗口关闭--*/
 function CloseWebPage(){
 if (navigator.userAgent.indexOf("MSIE") > 0) {
  if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
   window.opener = null;
   window.close();
  } else {
   window.open('', '_top');
   window.top.close();
  }
 }
 else if (navigator.userAgent.indexOf("Firefox") > 0) {
  window.location.href = 'about:blank ';
 } else {
  window.opener = null;
  window.open('', '_self', '');
  window.close();
 }
}
 
 
 
 
/*--获取当前时间--*/

function getNowFormatDate() {
    var date = new Date();
    var seperator1 = "-";
    var seperator2 = ":";
    date.setDate(date.getDate()+1); 
    var month = date.getMonth() + 1;
	
    var strDate = date.getDate();
    if (month >= 1 && month <= 9) {
        month = "0" + month;
    }
    if (strDate >= 0 && strDate <= 9) {
        strDate = "0" + strDate;
    }
    var currentdate = date.getFullYear() + seperator1 + month + seperator1 + strDate
            + " " + date.getHours() + seperator2 + date.getMinutes()
            + seperator2 + date.getSeconds();
    return currentdate;
}


/*--获取当前时间--*格式YYYY-MM-DD-M-S/*/

function CurentTime()
    { 
        var now = new Date();
       
        var year = now.getFullYear();       //年
        var month = now.getMonth() + 1;     //月
        var day = now.getDate();            //日
       
        var hh = now.getHours();            //时
        var mm = now.getMinutes();          //分
        var ss = now.getSeconds();     //获取当前秒数(0-59)
        var mss =  now.getMilliseconds();    //获取当前毫秒数(0-999)
       
        var clock = year + "-";
       
        if(month < 10)
            clock += "0";
       
        clock += month + "-";
       
        if(day < 10)
            clock += "0";
           
        clock += day + "-";
       
        if(hh < 10)
            clock += "0";
           
        clock += hh + "-";
        if (mm < 10) clock += '0'; 
        
        clock += mm+ "-"; 
        
        if (ss < 10) clock += '0'; 
        
        clock += ss+ "-"; 
        
        if (mss < 10) clock += '0'; 
        
        clock += mss; 
        
        
        return(clock); 
    } 

/*--登录验证--*/

function  loginsession()
{
	    var timestamp3 = new Date().getTime(); 
		var person="userName=1"+"&t="+timestamp3;
		
		var bool=new Boolean;
			bool=false;
		xmlhttp=null;
		postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
		{			
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{			
				var myobj=eval(xmlhttp.responseText);  
			try{					
					if(myobj[0].userName!=null)
					{
						bool= true;						
					}else{					
						alert("登录过期 重新登录");
						window.location.href="index.html";  
						return false;
					}					
				}catch(err)
				{			
					alert("登录过期 重新登录");
					window.location.href="index.html";  
					return false;		 
				}
			}
		});
	return bool;
}




/*--POST-SEND--*/
function postloadXMLDoc(url,postvlue,cfunc)
{
	if (window.XMLHttpRequest)
	 {// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	 }
	 else
	 {// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	 }
  
	if (xmlhttp!=null) 
	 {
	   xmlhttp.onreadystatechange=cfunc;
	   xmlhttp.open("POST",url,true);
	   xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	   xmlhttp.send(postvlue);
		//xmlhttp.send("userName="+inputname+"&userPassword="+inputpass);
		//xmlhttp.send();
	 }else
	 {
	  alert("Your browser does not support XMLHTTP.");
	 }

}

/////////////


function loadXMLDoc(url,cfunc)
{
 if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
 else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }  
	if (xmlhttp!=null) 
	{
	xmlhttp.onreadystatechange=cfunc;
	xmlhttp.open("POST",url,true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");	
	xmlhttp.send("userName="+inputname+"&userPassword="+inputpass);
	//xmlhttp.send();
	}else
		{
		alert("Your browser does not support XMLHTTP.");
		}

}





function searchload4() {
     var tomachineCode=getURLParameter("machineCode");
     var tomachineModel=getURLParameter("machineModel");
        showLoading();
     if(tomachineCode!=null&&tomachineCode!=""&&tomachineModel!=null&&tomachineModel!="")
     {
     
     var Div=document.getElementById("div1");
         Div.innerHTML="";
        var Div3=document.getElementById("div3");
         Div3.innerHTML="";
        
        var table=document.createElement("table");
        table.width="100%";
        table. border="0" ;
        table.cellspacing="0" ;												
        table.align="center";												
        table.border="1" ;
        table.bordercolor="#C0C0C0";
        //table.style="font-size: 11pt;"
        
        var tbody=document.createElement("tbody");
        tbody.align="center";
        /*--表头--*/
        var tr=document.createElement("tr");
        tr.align="center";
        var th=document.createElement("th");
            th.align="center";
            th.innerHTML="整机编码";
            tr.appendChild(th);
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="整机机型";
            tr.appendChild(th);
           
            tbody.appendChild(tr);
          
            
            tr=document.createElement("tr");
            th=document.createElement("th");
            th.innerHTML=tomachineCode;
            tr.appendChild(th);
            
            th=document.createElement("th");
            th.innerHTML=tomachineModel;
            tr.appendChild(th);
             
            tbody.appendChild(tr);           
                        
            
            tr=document.createElement("tr");
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="测试项目";
            tr.appendChild(th);            
           
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="测试结果";
            tr.appendChild(th);            
            
           /* th=document.createElement("th");
            th.align="center";
            th.innerHTML="参数上限";
            tr.appendChild(th);
           
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="参数下限";
            tr.appendChild(th);*/
            
            tbody.appendChild(tr);
            
            
            
            
            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="软件版本";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='softversion' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="老化时间";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='oldtime' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="输入电压是否平衡";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='voltageinyes' name='voltagein' value='1' />合格<input type='radio' id='voltageinno' name='voltagein' value='0' />不合格        ";
            tr.appendChild(th);

            tbody.appendChild(tr);

            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="输出电压是否平衡";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='voltageoutyes' name='voltageout' value='1' />合格<input type='radio' id='voltageoutno' name='voltageout' value='0' />不合格        ";
            tr.appendChild(th);

            tbody.appendChild(tr);




            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="修正后母线回显电压";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='changedcvoltage' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);

            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="实测电压";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='dcvoltage' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);




            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="无PG矢量模式，电机旋转自学习是否成功";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='studyyes' name='study' value='1' />合格<input type='radio' id='studyno' name='study' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="1Hz电流波形，是否为平滑的正弦波";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='hzyes' name='hz' value='1' />合格<input type='radio' id='hzno' name='hz' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);




            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="升/降频过程中的输出波形是否正常";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='updownyes' name='updown' value='1' />合格<input type='radio' id='updownno' name='updown' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);





            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="制动功能是否正常";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='breakingyes' name='breaking' value='1' />合格<input type='radio' id='breakingno' name='breaking' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);




            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="输入电流是否平衡";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='currentyes' name='current' value='1' />合格<input type='radio' id='currentno' name='current' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="带载运行，实测相电流IU";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='iu' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="带载运行，实测相电流IV";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='iv' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="带载运行，实测相电流IW";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='iw' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="修正回显电流后的值";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='changecurrent' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="变频器温度";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='text' id='templete' value=''"+">";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="端子功能是否正常";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='didoyes' name='dido' value='1' />合格<input type='radio' id='didono' name='dido' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="过流功能是否正常";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='overcurrentyes' name='overcurrent' value='1' />合格<input type='radio' id='overcurrentno' name='overcurrent' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);



            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="过压功能是否正常";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='overvoltageyes' name='overvoltage' value='1' />合格<input type='radio' id='overvoltageno' name='overvoltage' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);


            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="转追功能是否正常";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='rmpyes' name='rmp' value='1' />合格<input type='radio' id='rmpno' name='rmp' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);



            tr=document.createElement("tr");

            th=document.createElement("th");
            th.align="center";
            th.innerHTML="是否恢复默认值";
            tr.appendChild(th);
            
            
            th=document.createElement("th");
            th.align="center";
            th.innerHTML="<input type='radio' id='restyes' name='rest' value='1' />合格<input type='radio' id='restno' name='rest' value='0' />不合格";
            tr.appendChild(th);

            tbody.appendChild(tr);



            table.appendChild(tbody);
												
		    Div.appendChild(table);	

            var timestamp3 = new Date().getTime(); 
            var person="userName=1"+"&t="+timestamp3;

            var bool=new Boolean;
                bool=false;
                xmlhttp=null;
            postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
            {			
                if (xmlhttp.readyState==4 && xmlhttp.status==200)
                {			
                    var myobj=eval(xmlhttp.responseText);  
                    try{						
                        if(myobj[0].userName!=null)
                            {
                                showend();
                            }else
                            {
                                showend();
                                alert("登录过期 重新登录");
                                window.location.href="index.html";  
                                return false;
                            }
                        }catch(err)
                        {
                            showend();
                            alert("登录过期 重新登录");
                            window.location.href="index.html";  
                            return false;
                        }
                }
            });
     }else
     {
            alert("查询不到该信息");
            
            CloseWebPage();

     }
}
function newparseFloat(x)
{
    if(isNaN(parseFloat(x)))
    {
         throw "empty";
    }
    
        return parseFloat(x);
    

}

var roidbool=true;

 function testoversetclick()
 {
   showLoading();

    var timestamp3 = new Date().getTime();

    var person="userName=1"+"&t="+timestamp3;

    var bool=new Boolean;

    bool=false;

    xmlhttp=null;

    postloadXMLDoc("manager/userlogin/selsctuserloginsession",person,function()			
    {			
        if (xmlhttp.readyState==4 && xmlhttp.status==200)
        {			
            var myobj=eval(xmlhttp.responseText);  
                try{						
                    if(myobj[0].userName!=null)
                        {    
            
                        roidbool=true;
                        var STRINGoldtime  =  CurentTime();
                        /*软件版本	id='softversion'
                        老化时间	id='oldtime'
                        输入电压是否平衡	'voltageinyes'合格'voltageinno'不合格
                        输出电压是否平衡	voltageoutyes合格voltageoutno不合格
                        修正后母线回显电压	changedcvoltage
                        实测电压	dcvoltage
                        无PG矢量模式，电机旋转自学习是否成功	studyyes合格studyno不合格
                        1Hz电流波形，是否为平滑的正弦波	hzyes合格hzno不合格
                        升/降频过程中的输出波形是否正常	updownyes合格updownno不合格
                        制动功能是否正常	breakingyes合格breakingno不合格
                        输入电流是否平衡	currentyes合格currentno不合格
                        带载运行，实测相电流IU	iu
                        带载运行，实测相电流IV	iv
                        带载运行，实测相电流IW	iw
                        修正回显电流后的值	changecurrent
                        变频器温度	templete
                        端子功能是否正常	didoyes合格didono不合格
                        过流功能是否正常	overcurrentyes合格overcurrentno不合格
                        过压功能是否正常	overvoltageyes合格overvoltageno不合格
                        转追功能是否正常	rmpyes合格rmpno不合格
                        是否恢复默认值      restyes合格restno不合格
                        
                                                */
                        var arrayObjname = new Array();
                        arrayObjname. push("软件版本");
                        arrayObjname. push("老化时间");
                        arrayObjname. push("输入电压是否平衡");
                        arrayObjname. push("输出电压是否平衡");
                        arrayObjname. push("修正后母线回显电压");
                        arrayObjname. push("实测电压");
                        arrayObjname. push("无PG矢量模式，电机旋转自学习是否成功");
                        arrayObjname. push("1Hz电流波形，是否为平滑的正弦波");
                        arrayObjname. push("升/降频过程中的输出波形是否正常");
                        arrayObjname. push("制动功能是否正常");
                        arrayObjname. push("输入电流是否平衡");
                        arrayObjname. push("带载运行，实测相电流IU");
                        arrayObjname. push("带载运行，实测相电流IV");
                        arrayObjname. push("带载运行，实测相电流IW");
                        arrayObjname. push("修正回显电流后的值");
                        arrayObjname. push("变频器温度");
                        arrayObjname. push("端子功能是否正常");
                        arrayObjname. push("过流功能是否正常");
                        arrayObjname. push("过压功能是否正常");
                        arrayObjname. push("转追功能是否正常");
                        arrayObjname. push("是否恢复默认值"); 

                        var arrayObj = new Array();

                        try{ 
                            arrayObj. push(newparseFloat(document.getElementById("softversion").value));
                            arrayObj. push(newparseFloat(document.getElementById("oldtime").value));
                            arrayObj. push(newparseFloat( check_radio("voltagein")));
                            arrayObj. push( newparseFloat(check_radio("voltageout")));
                            arrayObj. push(newparseFloat(document.getElementById("changedcvoltage").value));
                            arrayObj. push(newparseFloat(document.getElementById("dcvoltage").value));
                            arrayObj. push(newparseFloat(check_radio("study")));
                            arrayObj. push(newparseFloat(check_radio("hz")));
                            arrayObj. push(newparseFloat(check_radio("updown")));
                            arrayObj. push(newparseFloat(check_radio("breaking")));
                            arrayObj. push(newparseFloat(check_radio("current")));
                            arrayObj. push(newparseFloat(document.getElementById("iu").value));
                            arrayObj. push(newparseFloat(document.getElementById("iv").value));
                            arrayObj. push(newparseFloat(document.getElementById("iw").value));
                            arrayObj. push(newparseFloat(document.getElementById("changecurrent").value));
                            arrayObj. push(newparseFloat(document.getElementById("templete").value));
                            arrayObj. push(newparseFloat(check_radio("dido")));
                            arrayObj. push(newparseFloat(check_radio("overcurrent")));
                            arrayObj. push(newparseFloat(check_radio("overvoltage")));
                            arrayObj. push(newparseFloat(check_radio("rmp")));
                            arrayObj. push(newparseFloat(check_radio("rest"))); 
                        }catch(errr)
                        {
                            alert("输入值不为数字或者有选项未选择");
                            showend();
                            return;
                        }

                        var httpjsonsend = [];
                        for(var  i=0;i<21;i++)
                        {
                            var json1 = {};
                            /*createJson(json1,"machineModel", getURLParameter("machineCode"));
                                createJson(json1,"machineName", arrayObjname[i]);
                            createJson(json1,"originalValue", arrayObj[i]);
                            createJson(json1,"ratio", "1");
                            createJson(json1,"data",arrayObj[i]);
                            createJson(json1,"dataMin", arrayObj[i]);
                            createJson(json1,"dataMax", arrayObj[i]);
                            createJson(json1,"faultFlag", "1");
                            createJson(json1,"testTime", STRINGoldtime);*/
                            json1["machineModel"] = getURLParameter("machineCode");
                            json1["machineName"] = arrayObjname[i];
                            json1["originalValue"] =  arrayObj[i];
                            json1["ratio"] = "1";
                            json1["data"] = arrayObj[i];
                            json1["dataMin"] = arrayObj[i];
                            json1["dataMax"] = arrayObj[i];
                            json1["faultFlag"] = "1";
                            json1["testTime"] = STRINGoldtime; 
                            httpjsonsend.push(json1);                                  

                        }
                        var jstring= JSON.stringify(httpjsonsend);
                   //     return;            
                                
                        var  urllink="";

                        var person="";

                        var timestamp3 = new Date().getTime();
                            
                        urllink="manager/machinetestlog/insertmachinetestLog";

                    /* insert into 整机测试记录 
                            (测试编码,名称,原始值 ,系数,数据,数据下限,数据上限 ,故障标示 ,测试时间)
                        values
                            (#{machineModel},
                            #{machineName},
                            #{originalValue},
                            #{ratio},
                            #{data},
                            #{dataMin},
                            #{dataMax},
                            #{faultFlag},
                            #{testTime},
                                        
                            )  */ 
                        var roidnumber="1";

                        if(roidbool==false){
                        roidnumber="0";
                        }
                        else{
                        roidnumber="1";
                        }
                        /*--------spring服务端处理所有的导入,这个地方发送需要录入的json数组,其他的表在服务端写入 
                        machineModel:传入所有测试数据的json数组
                        machineName:传入最终测试结果是否合格
                        originalValue:测试方式
                        ratio:旧规则的时间yyyy-mm-dd-min-s
                        spring服务端会重新处理所有的数据表插入和更新
                        ---------*/
                        person="machineModel="+jstring
                        +"&machineName="+roidnumber
                        +"&originalValue="+"手动测试" 
                        +"&ratio="+STRINGoldtime                                           
                        +"&t="+timestamp3;

                        xmlhttp=null;
                       
                        postloadXMLDoc(urllink,person,function()	
                        {			
                            if (xmlhttp.readyState==4 && xmlhttp.status==200)
                            {			
                                var myobj=eval(xmlhttp.responseText);
                                showend();
                                if(myobj!=null)
                                {
                                    alert("导入成功");
                                    /*--新页面打开--*/   
                                    var url = "search3.html";
                                            
                                 /*   window.open(encodeURI(url + "?searchstring=" + getURLParameter("machineCode") 
                                    +"&oldtesttime="+STRINGoldtime+"&machieModelcode="+getURLParameter("machineCode")
                                    +"&machieModelmodel="+getURLParameter("machineModel")));*/

                                     window.location.href=url + "?searchstring=" + getURLParameter("machineCode") 
                                    +"&oldtesttime="+STRINGoldtime+"&machieModelcode="+getURLParameter("machineCode")
                                    +"&machieModelmodel="+getURLParameter("machineModel");

                                   //  CloseWebPage();

                                }else
                                {
                                    alert("无权限或者导入失败");
                                }                                        

                            }
                        });  
                        
                    }else
                    {
                        showend();
                        alert("登录已经过期 重新登录");
                        window.location.href="index.html";  
                        return false;

                    }
            }catch(err)
            {
                showend();
                alert("登录过期 重新登录");
                window.location.href="index.html";  
                return false;

            }
    }

});

 }
function check_radio(x){                                        
    var New=document.getElementsByName(x);
    var strNew="";
    for(var i=0;i<New.length;i++){
        if(New.item(i).checked){
        strNew=New.item(i).getAttribute("value");
        }
    }
    if(strNew==""){
        strNew="";
    }else
    {
        if(strNew==0){
        roidbool=false;
    }

    }


    return strNew;
}

 /*动态创建json参数：prop = 属性，val = 值*/
function createJson(json,prop, val) {
    // 如果 val 被忽略
    if(typeof val === "undefined") {
        // 删除属性
        delete json[prop];
    }
    else {
        // 添加 或 修改
        json[prop] = val;
    }
}




function testupfile()
{
var handsondata=hot.getData();
    for(var i=0;i<handsondata.length;i++)
    {  
        var handdata=handsondata[i];


        
    }
}



var datahandsontable = [
    ["",  "Kia", "Nissan", "Toyota", "Honda"],
    ["2008",  10, 11, 12, 13],
    ["2009",  20, 11, 14, 13],
    ["2010",  30, 15, 12, 13]
];
  var colheaderdata=['日期', '条码', '软件版本', '键盘软件版本', '老化时间', '实测输入电压', '输入电压是否平衡', '输出电压是否平衡', '修正后母线回显电压/实测电压', '电机旋转自学习是否成功',
                 '1Hz电流波形，是否为平滑的正弦波', '升/降频过程中的输出波形是否正常', '输入电流是否平衡',
                  '制动功能是否正常', '带载运行，实测相电流IU', '带载运行，实测相电流IV', '带载运行，实测相电流IW', '修正回显电流后的值I', 
                  '变频器温度℃', 'AI端子测试状态', 'DI端子测试状态', '试运行状态', '保护功能测试过流', '保护功能测试过压', '保护功能测试转追', '恢复默认值', '调试人'];

var container = document.getElementById('dataTable');

var hot = new Handsontable(container,
 {
       data:  null,      
    maxRows: 30,
    maxCols: 27 ,
    
    startRows: 30,
  startCols: 27 ,
  fixedColumnsLeft: 3,

   colHeaders: colheaderdata,
    
     columns: [
    {  type: 'date',
      dateFormat: 'MM/DD/YYYY',
      correctFormat: true,
      defaultDate: '01/01/2016'
    },
    {     
    },
    {     
    },
    {      
    },
    { type: 'numeric',
      format: '0.00',    
    },
    {     
    },
    {  type:'autocomplete',

     source:['合格','不合格'],

     strict:true,                        //值为true，严格匹配

    // allowInvalid:true              //值为true时，允许输入值作为匹配内容，只能在strict为true时使用   
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     
    },
    {     
    },
    {     
    },
    {     
    },
    {     
    },
    { type:'autocomplete',

     source:['合格','不合格'],

     strict:true,      
    },
    {   type:'autocomplete',

     source:['合格','不合格'],

     strict:true,    
    },
    { type:'autocomplete',

     source:['合格','不合格'],

     strict:true,      
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {   type:'autocomplete',

     source:['合格','不合格'],

     strict:true,    
    },     
    
    {      
    }
    
    ]


  });





/*$("#dataTable").handsontable({
    data:  null,      
    maxRows: 30,
    maxCols: 27 ,
    
    startRows: 30,
  startCols: 27 ,
  fixedColumnsLeft: 3,

   colHeaders: colheaderdata,
    
     columns: [
    {  type: 'date',
      dateFormat: 'MM/DD/YYYY',
      correctFormat: true,
      defaultDate: '01/01/2016'
    },
    {     
    },
    {     
    },
    {      
    },
    { type: 'numeric',
      format: '0.00',    
    },
    {     
    },
    {  type:'autocomplete',

     source:['合格','不合格'],

     strict:true,                        //值为true，严格匹配

    // allowInvalid:true              //值为true时，允许输入值作为匹配内容，只能在strict为true时使用   
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     
    },
    {     
    },
    {     
    },
    {     
    },
    {     
    },
    { type:'autocomplete',

     source:['合格','不合格'],

     strict:true,      
    },
    {   type:'autocomplete',

     source:['合格','不合格'],

     strict:true,    
    },
    { type:'autocomplete',

     source:['合格','不合格'],

     strict:true,      
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {     type:'autocomplete',

     source:['合格','不合格'],

     strict:true,  
    },
    {   type:'autocomplete',

     source:['合格','不合格'],

     strict:true,    
    },     
    
    {      
    }
    
    ]
  
 
  
});*/







/*function Map(){
this.container = new Object();
}


Map.prototype.put = function(key, value){
this.container[key] = value;
}


Map.prototype.get = function(key){
return this.container[key];
}


Map.prototype.keySet = function() {
var keyset = new Array();
var count = 0;
for (var key in this.container) {
// 跳过object的extend函数
if (key == 'extend') {
continue;
}
keyset[count] = key;
count++;
}
return keyset;
}


Map.prototype.size = function() {
var count = 0;
for (var key in this.container) {
// 跳过object的extend函数
if (key == 'extend'){
continue;
}
count++;
}
return count;
}


Map.prototype.remove = function(key) {
delete this.container[key];
}


Map.prototype.toString = function(){
var str = "";
for (var i = 0, keys = this.keySet(), len = keys.length; i < len; i++) {
str = str + keys[i] + "=" + this.container[keys[i]] + ";\n";
}
return str;
}*/



