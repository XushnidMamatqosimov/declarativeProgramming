package comparatorCollectors.task1.task2;

import java.io.FileWriter;
import java.io.IOException;

public class XMLFileYaratish {
    public static void main(String[] args) throws IOException {
        String xmlFile = """
                <students>
                     <student id="1">
                          <name>Tarra Prohaska</name>
                          <gender>MALE</gender>
                          <age>16</age>
                     </student>
                          <student id="2">
                          <name>Allen Dicki</name>
                          <gender>FEMALE</gender>
                          <age>29</age>
                     </student>
                           <student id="3">
                           <name>Jack Davis</name>
                           <gender>MALE</gender>
                           <age>17</age>
                     </student>
                </students>
                """;
        try (FileWriter fileWriter = new FileWriter("table.xml")) {
            fileWriter.write(xmlFile);
            System.out.println("XML file created successfully ");
        } catch (Exception e) {
            System.out.println("File yaratishda xatolik " + e.getMessage());
        }
    }
}
