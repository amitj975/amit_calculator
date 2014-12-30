package com.example.amit_calculator;


import java.util.Stack;


import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.os.Build;

public class MainActivity extends ActionBarActivity {
	
	Button digit1,digit2,digit3,digit4,digit5,digit6,digit7,digit8,digit9,digit0,digit00;
	Button bs,dec,eq,plus,s,m,q,b1,b2,exp;
	String string="";
	double ans;
	
	TextView display;
	
	int precedence_order(char c){
		 if(c=='*' ||c=='/')
		    return 2;
		 else if(c=='^')
		    return 3;
		 else if(c==')'||c=='('){
			 return 0;
		 }
		 else
		    return 1;
		}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		
		digit1=(Button)findViewById(R.id.button1);
		digit2=(Button)findViewById(R.id.button3);
		digit3=(Button)findViewById(R.id.button4);
		digit4=(Button)findViewById(R.id.button5);
		digit5=(Button)findViewById(R.id.button6);
		digit6=(Button)findViewById(R.id.button7);
		digit7=(Button)findViewById(R.id.button8);
		digit8=(Button)findViewById(R.id.button9);
		digit9=(Button)findViewById(R.id.button10);
		digit0=(Button)findViewById(R.id.button15);
		digit00=(Button)findViewById(R.id.button16);
		bs=(Button)findViewById(R.id.button2);
		plus=(Button)findViewById(R.id.button11);
		s=(Button)findViewById(R.id.button12);
		m=(Button)findViewById(R.id.button13);
		dec=(Button)findViewById(R.id.button14);
		q=(Button)findViewById(R.id.button17);
		exp=(Button)findViewById(R.id.button18);
		b1=(Button)findViewById(R.id.button19);
		b2=(Button)findViewById(R.id.button20);
		eq=(Button)findViewById(R.id.button21);
		
	


		display=(TextView)findViewById(R.id.editText1);
		
		string =""; 
		display.setText(string);
		
		digit1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=1;
				display.setText(string);
			}
		});
		digit2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=2;
				display.setText(string);
			}
		});
		digit3.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=3;
				display.setText(string);
			}
		});
		digit4.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=4;
				display.setText(string);
			}
		});
		digit5.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=5;
				display.setText(string);
			}
		});
		digit6.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=6;
				display.setText(string);
			}
		});
		digit7.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=7;
				display.setText(string);
			}
		});
		digit8.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=8;
				display.setText(string);
			}
		});
		digit9.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=9;
				display.setText(string);
			}
		});
		digit0.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=0;
				display.setText(string);
			}
		});
		digit00.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+="00";
				display.setText(string);
			}
		});
		bs.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string=string.substring(0,(string.length()-1>0)?string.length()-1:0);
				display.setText(string);
			}
		});	
		plus.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+="+";
				display.setText(string);
			}
		});
		s.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+="-";
				display.setText(string);
			}
		});
		m.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+="*";
				display.setText(string);
			}
		});
		q.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+="/";
				display.setText(string);
			}
		});
		dec.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=".";
				display.setText(string);
			}
		});
		eq.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {

				ans=cal(string);
				string="";
				string+=ans;
				display.setText(string);
			}

			private double cal(String string) {
				int  l,i;
			    String s,p ="";
			    
			    string="("+string+")";
			    
			    s=string;

			    l=s.length();
			 


			    Stack <Character> e = new Stack<Character>() ;

			 

			    for(i=0;i<l;i++)
			    {
			        if(s.charAt(i)=='(')
			        {
			            e.push(s.charAt(i));
			        }

			        else if(s.charAt(i)==')')
			        {
			        	
			            while(!e.empty()&&(Character) e.peek()!='(')
			                {
			            		
			                    p+=e.pop();
			                }
			            
			            if(!e.empty())
			            e.pop();
			            
			        }

			        else if(s.charAt(i)>=48 && s.charAt(i)<=57||s.charAt(i)=='.')
			            {
			                while(i<l&&(s.charAt(i)>=48 && s.charAt(i)<=57||s.charAt(i)=='.'))
			                {
			                    p+=s.charAt(i);
			                    i++;
			                }
			                p+=' ';
			                i--;
			            }
			            else
			                {
			            		if(s.charAt(i)=='-'){
			            			if(!((s.charAt(i-1)>=48 && s.charAt(i-1)<=57)||s.charAt(i-1)=='.'))	
			            			{
			            				i++;
			            				p+='$';
			            				 while(i<l&&(s.charAt(i)>=48 && s.charAt(i)<=57||s.charAt(i)=='.'))
			 			                {
			 			                    p+=s.charAt(i);
			 			                    i++;
			 			                }
			 			                p+=' ';
			 			                i--;
			 			                continue;
			            			
			            			}
			            		}
			            	
			                    if(e.empty() || precedence_order(s.charAt(i))>precedence_order((Character)e.peek()))
			                    {
			                        e.push(s.charAt(i));
			                    }
			                    else
			                    {
			                        while(!e.empty() && precedence_order(s.charAt(i))<=precedence_order((Character)e.peek()) )
			                            {
			                                p+=e.pop();
			                            }

			                        e.push(s.charAt(i));
			                        }
			                    }
			            }
			    
			    while(!e.empty())
			        {
			            if((Character)e.peek()!='(' && (Character)e.peek()!=')')
			                p+=e.pop();

			            e.pop();
			        }
			  
			    
			    l=p.length();
			  
			    Stack <Double>c =new Stack<Double>();

			    for(i=0;i<l;i++)
			    {
			        if(((p.charAt(i)>=48 && p.charAt(i)<=57)||p.charAt(i)=='.')||p.charAt(i)=='$')
			            {
			        	int g1=0;
			        	
			        	if(p.charAt(i)=='$'){
			        		g1=1;
			        		i++;
			        	}
			        	
			        		double j=0;
			                int fl=0,f2=0;
			                
			                if(p.charAt(i)=='.'){
			                	fl=1;
			                	i++;
			                }
			                
			                while(i<l&&(p.charAt(i)>=48 && p.charAt(i)<=57||p.charAt(i)=='.'))
			                    {
			                	 if(p.charAt(i)=='.'){
					                	fl=1;
					                	i++;
					                	continue;
					                	
					                }
					                
			                	if(fl==0)
			                	{ j=(p.charAt(i)-48)+j*10;
			                	}
			                	else{
			                		j+=((double)(p.charAt(i)-48))*Math.pow(10, -(++f2));
			                	}
			                	i++;
			                    
			                    }
			                
			               
			                
			                if(g1==1){
			                	 c.push(j*-1);
			                }
			                else{
			                	 c.push(j);
			                }
			                
			            }
			        else if(p.charAt(i)==' '){
			        	
			        }

			        else
			        {
			           double k=0;
			           
			           if(!c.empty())
			           k=(double) c.pop();
			      
			           double j=0;
			           
			           if(!c.empty())
			           j=(double)c.pop();
			          

			            if(p.charAt(i)=='+')
			            {
			                c.push(k+j);
			            }
			            else if(p.charAt(i)=='-')
			            {
			                c.push(j-k);
			            }
			            else if(p.charAt(i)=='*')
			            {
			                c.push(j*k);
			            }
			            else if(p.charAt(i)=='/')
			            {
			                c.push(j/k);
			            }
			            else if(p.charAt(i)=='^')
			            {
			                c.push((Math.pow(j, k)));
			            }
			        }
			 }
				return c.pop() ;
	
			}
			
		});
		
		exp.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+="^";
				display.setText(string);
			}
		});
		b1.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+="(";
				display.setText(string);
			}
		});
		b2.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				
				string+=")";
				display.setText(string);
			}
		});
}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}


	
}
