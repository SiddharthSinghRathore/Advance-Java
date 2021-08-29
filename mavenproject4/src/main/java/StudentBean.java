
public class StudentBean 
{
    private String name;
    private boolean empty;

    public boolean isEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }
    
    
    public void setName(String name)
    {
        this.name=name;
        
    }
    public String getName()
    {
        return name;
        
    }
}
