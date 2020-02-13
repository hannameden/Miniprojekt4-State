public class StateE extends State
  {
  public StateE(StateClient stateMachine)
    {
    stateMachine.setMessage("Din produkt levereras");
    new Thread(new Runnable(){public void run()
      {
      try{Thread.sleep(20000);}catch(Exception e){}
      setState(new StateA(stateMachine));            
      }}).start();
    }
  
  @Override
  public void handleCancel(StateClient stateMachine)
    {
    setState(new StateA(stateMachine));            
    }
  }