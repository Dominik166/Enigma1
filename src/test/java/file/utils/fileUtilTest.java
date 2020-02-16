package file.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class fileUtilTest {

    private final int NUMBER = 3;

   private final String pathToFile = getClass().getResource("/fileUtils/test.txt").getPath();
   private final String firstLine = "Ala ma kota, kot ma Ale";


    @Test
    protected void testIfNumberOdLineAreEquals(){

       String fileContent = FileTool.getFileContent(pathToFile);
       System.out.println(fileContent);
       String[] split = fileContent.split("\n");
       Assertions.assertEquals(NUMBER, split.length );
        Assertions.assertEquals(firstLine, split[0]);
   }


   @Test

    protected void howDoesSplitWorks(){
       String textToSplit = "1,2,3,4,5";
       String[] split = textToSplit.split(",");

        for (String s : split){
            System.out.println(s);
        }
       System.out.println(split.length);
   }
}
