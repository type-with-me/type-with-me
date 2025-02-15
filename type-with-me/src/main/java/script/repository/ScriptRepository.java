package script.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class ScriptRepository {

    public List<String> selectAllScripts() {
        String filePath = "type-with-me/src/main/java/script/db/script.dat"; // 파일 경로
        List<String> allScripts = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String script = "";
            while((script = br.readLine()) != null) {
                allScripts.add(script.trim());
            }
        } catch (Exception e) {
            System.out.println("파일 읽기 실패: " + e.getMessage());
        }
        return allScripts;
    }
}
