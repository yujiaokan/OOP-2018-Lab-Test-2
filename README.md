# Object Oriented Programming Lab Test 2 2018

For todays' lab test, you will be writing a parser for ABC music files in Java. ABC music files are plain text ascii files that store sheet music notation for tunes. ABC music files can contain the notation for multiple tunes in one file and tunes are seperated by one or more blank lines. The file you will be parsing today has 100 tunes in it. Each tune in the file consists of headers which are the letters X, T, R etc followed by a :. The actual music notes follow the headers. The X header is called the index number of the tune in the file and is always an integer. The T header is the tune title. Tunes always begins with an X header and there is always at least one title, though there can be optionally multiple T headers as tunes can have multiple titles. There are other headers, but we are only interested in the tites and the index numbers for the purpose of this test.

Here is an extract from the file you will be parsing today that shows the ABC notation for one tune:

```
X:4
T:Piper's Chair, The
T:Cathaoir an Ph\'iob\'aire
R:jig
D:Bobby Gardiner: His Master's Choice.
Z:id:hn-jig-4
M:6/8
K:G
DGG GFD|c2c cAc|ded cAG|FAG FEF|DGG GFD|c2c cAc|ded cAF|1 AGF G3:|2 AGF GBd||
|:~g3 agf|d2g gfg|GFG =fef|A2B cBA|GBd g2f|d2e fdc|Bdd cAF|1 AGF GBd:|2 AGF G3||
```
The tune above has an index number of 4 (X:4) and has two titles "Piper's Chair, The" (T:Piper's Chair, The) and "Cathaoir an Ph\'iob\'aire" (T:Cathaoir an Ph\'iob\'aire). 

Instructions:

- Create a new Java git repository on github and call it JavaTest. Make sure you specify Java as the language on github so you get a Java .gitignore file
- Clone the repository to your computer
- Create the folder structure for a java package in the project you cloned, called ie.dit and download this abc file to the root of the folder structure you created.
- Create a class Tune in the package ie.dit with private fields for x, title and altTitle. x should be of type int and title and altTitle should be strings. Create public accessor methods for these private fields.
- Write a toString method on the Tune class. This should return the fields formatted as x, title, altTitle. If the tune does not have an altTitle, then you should leave this part out. For example, the above tune would print:

    4, Piper's Chair, The, Cathaoir an Ph\'iob\'aire

- Write a class called TuneBook that has a field called tunes of type ```ArrayList``` of Tune objects
- Write a constructor for the TuneBook class that takes a single string as a parameter representing the name of the abc file to load. Write the code in this constructor that populates the tunes ArrayList from the contents of the ABC file. There should be one Tune object in the ArrayList for every tune in the file. If a tune has only one title, then the altTitle field of the tune should be null. If there are more than two titles for a tune, then you can ignore the third and subsequent titles.

    Here is some example code that loads and prints a text file you can use to get started writing this method:

    ```Java
    BufferedReader inputStream = null;
    try {
        inputStream = new BufferedReader(new FileReader("words.txt"));
        
        String l;
        while ((l = inputStream.readLine()) != null) 
        {
            System.out.println(l);
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
    ```
- Write a toString method on the TuneBook class that returns a string version of the tunes ArrayList, with each element of the ArrayList on a seperate line
- Write a method ```public Tune findTune(String title)``` on the TuneBook class that returns the first matching Tune from the ArrayList that contains the parameter ```title``` in the tune title or altTitle
- Create an interface called Player that has one method called play
- Implement the interface on the Tune class. The play method should just print the notation for the tune
- Put a main method on the TuneBook class that has the following code on it to test your code:

```Java
    public static void main(String[] args)
    {
        TuneBook tb = new TuneBook("hnj0.abc");
        System.out.println(tb);

        Tune t = tb.findTune("Scotsman over the Border");
        t.play();
    }
```