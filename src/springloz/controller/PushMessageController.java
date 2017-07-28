package springloz.controller;

import java.util.ArrayList;
import java.util.List;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import springloz.PushMessageAss;
import springloz.PushMessageRe;
import springloz.SingletonInner;


@RequestMapping("manager/pushmessage")
@Controller
public class PushMessageController {

	
	
	
	
	
	
	
	@RequestMapping(value="selscttepushmessage",method=RequestMethod.GET)	
	@ResponseBody
	public List<PushMessageRe>selscttepushmessage(){
		
		List<PushMessageRe> list=new ArrayList<PushMessageRe>();
		
		String pushmessage="";
		
		
		pushmessage=SingletonInner.getInstance().pushMessage.getPushmessage();
		
		try{		
			int loop=0;
			while(true){		
				//String push=new String();
			//	 push=SingletonInner.getInstance().pushMessage.getPushmessage();
				if(pushmessage.equals(SingletonInner.getInstance().pushMessage.getPushmessage()))					
				{					
					if(loop>60)
					{ 
						pushmessage	= SingletonInner.getInstance().pushMessage.getPushmessage().toString();
						loop=0;
						PushMessageRe pushMessageRe=new PushMessageRe();
						
						pushMessageRe.setPushmessagere("0");
						
						list.add(pushMessageRe);
						
						return list;						
					}		
					
				
					loop++;			
				}else {
					 
					pushmessage	= SingletonInner.getInstance().pushMessage.getPushmessage().toString();
				//	SingletonInner.getInstance().pushMessage.setPushmessage("0");
					
					PushMessageRe pushMessageRe=new PushMessageRe();
					
					pushMessageRe.setPushmessagere("1");
					
					list.add(pushMessageRe);
					
					return list;
				}
			
				Thread.sleep(1000);
			}		
		}catch(Exception log){
			
			  System.out.println("SingletonInner");  
			
			  PushMessageRe pushMessageRe=new PushMessageRe();
				
				pushMessageRe.setPushmessagere("0");
				
				list.add(pushMessageRe);
								
			  return list;
		}
		//return list;
	}
	
	
	
	
	
	
	
	@RequestMapping(value="selscttepushmessageass",method=RequestMethod.GET)	
	@ResponseBody
	public List<PushMessageAss>selscttepushmessageass(){
	
		List<PushMessageAss> list=new ArrayList<PushMessageAss>();
		
		String pushmessage="";
		
		pushmessage=SingletonInner.getInstance().pushMessage.getPushmessageass().toString();
		
		try{		
			int loop=0;
			while(true){				
				if(pushmessage.equals(SingletonInner.getInstance().pushMessage.getPushmessageass()))
				{					
					if(loop>60)
					{ 
						pushmessage	= SingletonInner.getInstance().pushMessage.getPushmessageass().toString();
						loop=0;
						PushMessageAss pushMessageRe=new PushMessageAss();
						
						pushMessageRe.setPushmessagere("0");
						
						list.add(pushMessageRe);
						
						return list;						
					}		
					
					
					loop++;			
				}else {
					 
					pushmessage	= SingletonInner.getInstance().pushMessage.getPushmessageass().toString();
					PushMessageAss pushMessageRe=new PushMessageAss();
					
					pushMessageRe.setPushmessagere("1");
					
					list.add(pushMessageRe);
					
					return list;
				}
			
			 Thread.sleep(1000);
			}		
		}catch(Exception log){
			
			  System.out.println("SingletonInner");  
			
			  PushMessageAss pushMessageRe=new PushMessageAss();
				
				pushMessageRe.setPushmessagere("0");
				
				list.add(pushMessageRe);
								
			  return list;
		}
		//return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
