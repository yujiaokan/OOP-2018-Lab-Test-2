package ie.dit;


public class Tune 
{
    private String title;
    private String altTitle;
    private String notation;
    private int x;


    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getNotation()
    {
        return notation;
    }

    public void setNotation(String notation)
    {
        this.notation = notation;
    }

    public String getAltTitle()
    {
        return altTitle;
    }

    public void setAltTitle(String title)
    {
        this.altTitle  = altTitle;
    }

    public String toString()
    {
        return "" + x + ", " + title 
            + altTitle != null ? ", " + altTitle : "";
    }
    
}