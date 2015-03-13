package gpa.calculator;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;



public class GPACalculatorActivity extends Activity implements OnClickListener
{
	private String[] creditValueItem = {"2","4","6"};
	private String[] gradeItem = {"A","B+","B","C+","C","D+","D","F"};
	
	private Button[] subj = new Button[13];
	private Button[] grade = new Button[13];
	private Button calculate;
	
	private int z = 0;
	private View temp;
	
	private TextView result;
	
	Subject[] sub = new Subject[13]; 
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate_activity);
        
        subj[0] = (Button)findViewById(R.id.subject1);   
        subj[1] = (Button)findViewById(R.id.subject2);
        subj[2] = (Button)findViewById(R.id.subject3);
        subj[3] = (Button)findViewById(R.id.subject4);   
        subj[4] = (Button)findViewById(R.id.subject5);
        subj[5] = (Button)findViewById(R.id.subject6);
        subj[6] = (Button)findViewById(R.id.subject7);
        subj[7] = (Button)findViewById(R.id.subject8);
        subj[8] = (Button)findViewById(R.id.subject9);
        subj[9] = (Button)findViewById(R.id.subject10);
        subj[10] = (Button)findViewById(R.id.subject11);
        subj[11] = (Button)findViewById(R.id.subject12);
        subj[12] = (Button)findViewById(R.id.subject13);
        
        grade[0] = (Button)findViewById(R.id.grade1);
        grade[1] = (Button)findViewById(R.id.grade2);
        grade[2] = (Button)findViewById(R.id.grade3);
        grade[3] = (Button)findViewById(R.id.grade4);
        grade[4] = (Button)findViewById(R.id.grade5);
        grade[5] = (Button)findViewById(R.id.grade6);
        grade[6] = (Button)findViewById(R.id.grade7);
        grade[7] = (Button)findViewById(R.id.grade8);
        grade[8] = (Button)findViewById(R.id.grade9);
        grade[9] = (Button)findViewById(R.id.grade10);
        grade[10] = (Button)findViewById(R.id.grade11);
        grade[11] = (Button)findViewById(R.id.grade12);
        grade[12] = (Button)findViewById(R.id.grade13);
        
        calculate = (Button)findViewById(R.id.ok);
        calculate.setOnClickListener(this);
        
        result = (TextView)findViewById(R.id.result);
        
        int i = 0;
        while (i<13)
        {
        	
        	sub[i] = new Subject();
        	
        	subj[i].setOnClickListener(this);
        	grade[i].setOnClickListener(this);
        	i++;
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
    	super.onCreateOptionsMenu(menu);
    	
    	MenuItem item = menu.add("About");
    	MenuItem help = menu.add("Help");
    	
    	return true;
    	
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	if(item.getTitle() == "About")
    	{
    		AlertDialog.Builder about = new AlertDialog.Builder(this);
    		about.setTitle("About");
    		about.setMessage("GPA Calculator v1.0. Developed by Lowt.");
    		about.create().show();
    		about.setCancelable(true);
    		
    	}
    	else if(item.getTitle() == "Help")
    	{
    		AlertDialog.Builder help = new AlertDialog.Builder(this);
    		help.setTitle("Help");
    		help.setMessage("This application support calculation of up to 7 subjects. If you want to calculate less than 7 subjects, just ignore the other button.");
    		help.create().show();
    		help.setCancelable(true);
    	}
    	return true;
    }
    
    public void onClick(View v)
    {
    	for(int s = 0; s < 13; s++)
    	{
    		if(v == subj[s])
    		{
    			temp = v;
    	
    			AlertDialog.Builder chList = new AlertDialog.Builder(this);
    			chList.setTitle("Set credit hour");
    		
    			chList.setItems(creditValueItem, new DialogInterface.OnClickListener()
    			{
    				public void onClick(DialogInterface dialog, int item)
    				{
    					Toast.makeText(getApplicationContext(), creditValueItem[item], Toast.LENGTH_SHORT).show();	
    					z = item;
    					for(int j = 0; j < subj.length; j++ )
    					{
    						if(temp == subj[j])
    						{
    							subj[j].setText(creditValueItem[z] + " Credit Hour");
    							double ch = 0;
    							/*if(creditValueItem[z] == "1")
    								ch = 1;*/
    							/*else*/ if(creditValueItem[z] == "2")
    								ch = 2;
    							/*else if(creditValueItem[z] == "3")
    								ch = 3;*/
    							else if(creditValueItem[z] == "4")
    								ch = 4;
    							/*else if(creditValueItem[z] == "5")
    								ch = 5;*/
    							else if(creditValueItem[z] == "6")
    								ch = 6;
    							
    							sub[j].setcreditValue(ch);
    							
    						}
    					}
    				}
    			
    			});
    		
    			chList.show();
    		}
    		
    		else if(v == grade[s])
    		{
    			temp = v;
    	    	
    			AlertDialog.Builder gradeList = new AlertDialog.Builder(this);
    			gradeList.setTitle("Set grade");
    		
    			gradeList.setItems(gradeItem, new DialogInterface.OnClickListener()
    			{
    				public void onClick(DialogInterface dialog, int item)
    				{
    					Toast.makeText(getApplicationContext(), gradeItem[item], Toast.LENGTH_SHORT).show();	
    					z = item;
    					for(int j = 0; j < grade.length; j++ )
    					{
    						if(temp == grade[j])
    						{
    							grade[j].setText("      Grade : " + gradeItem[z] + "      ");
    							
    							sub[j].setGrade(gradeItem[item]);
    						}
    					}
    				}
    			
    			});
    			gradeList.show();
    		}			
    	}
    	
    	if(v == calculate)
    	{
    		Semester sem  = new Semester();
    		for(int i = 0; i < 13; i++)
    		{
    			sem.setcreditValue(sub[i].getcreditValue());
    			sem.setGrade(sub[i].getGrade());
    			sem.calcTotalcreditValue();
    			sem.calcTotalGradePoint();
    		}
    		sem.calculateGpa();
    		double res = sem.getGpa();
    		String convertedResultValue = Double.toString(res);
    		result.setText(convertedResultValue);
    	}
    }
    
    
}