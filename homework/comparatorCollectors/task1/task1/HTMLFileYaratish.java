package comparatorCollectors.task1.task1;

import java.io.FileWriter;
import java.io.IOException;

public class HTMLFileYaratish {
    public static void main(String[] args) {
        String htmlContent = """
                ‹ table>
                     <tr>
                         <th›ID</th>
                         <th›name</th>
                         <th›gender</th>
                         <th>age</th>
                     </tr>
                     くtr＞
                         <td>1</td›
                         <td>Tarra Prohaska</td>
                         <td›MALE</td>
                         <td>16</td>
                     </tr>
                         <td›2</td>
                         < td›Allen Dicki</td›
                         <td>FEMALE</td>
                         <td>29</td>
                     </tr>
                     ‹tr›
                         <td>3</td>
                         <td>Jack Davis DVM</td>
                         <td›MALE</td>
                         <td>17</td>
                     </tr>
                </table>
                """;

        try(FileWriter fileWriter = new FileWriter("table.html")){
            fileWriter.write(htmlContent);
            System.out.println("HTML file created successfully ");
        } catch (IOException e) {
            System.out.println("File yozishda xatolik yuz berdi: "+e.getMessage());
        }
    }
}
