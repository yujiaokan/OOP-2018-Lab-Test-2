package ie.dit;
import java.io.*;
import java.util.*;

public class TuneParser
{

    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        for(Tune t:tunes)
        {
            sb.append(t + "\n");
        }
        return sb.toString();
    }
    ArrayList<Tune> tunes = new ArrayList<Tune>();
    public TuneParser(String fileName)
    {
        BufferedReader inputStream = null;

        try {
            inputStream = new BufferedReader(new FileReader(fileName));
            
            String l;
            Tune tune = null;
            while ((l = inputStream.readLine()) != null) 
            {
                if (l.startsWith("X:"))
                {
                    Tune tune = new Tune();
                    tunes.add(tune);
                    tune.setX(Integer.parseInt(l.substring(3)));
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        } 
        finally 
        {
            if (inputStream != null) {
                try
                {
                    inputStream.close();
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        TuneParser tp = new TuneParser("hnj0.abc");
    }
}