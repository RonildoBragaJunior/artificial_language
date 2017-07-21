package org.artificial.language.util;

import java.io.*;


public class SentenceReader {

    public static void main(String[] args) throws Exception{

        String csvFile = "/Users/Ronildo/Developer/projects/personal/artificial_language/src/main/resources/static/db/sentences.csv";
        String line = "";
        String cvsSplitBy = ",";

        BufferedWriter bw = null;
        FileWriter fw = null;
        fw = new FileWriter("/Users/Ronildo/Developer/projects/personal/artificial_language/src/main/resources/static/db/sentences.sql");
        bw = new BufferedWriter(fw);


        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] country = line.split(cvsSplitBy);
                bw.write("insert into sentence  (word_word_id, name) values('"+country[0]+"', '"+country[3].replace("'","''")+"');\n");


            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bw != null)
                    bw.close();
                if (fw != null)
                    fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
