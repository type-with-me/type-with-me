package script.testrun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import script.service.ScriptService;

public class Application {
    private static final ScriptService scriptsService = new ScriptService();

    public static void main(String[] args) {
        startTypingPractice();
    }

    /*
     * 타자 연습 실행
     * */
    private static void startTypingPractice() {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        countDown();

        List<String> scripts = scriptsService.getFiveRandomScripts();

        long startTime = System.currentTimeMillis(); // 시작 시간

        scripts.forEach(script -> {
            try {
                System.out.println(">>> 문장: " + script);

                System.out.print(">>> 입력: ");
                String userInput = br.readLine();

                while(!userInput.equals(script)) {
                    System.out.println("❌ 오타가 있습니다! 다시 입력하세요.");
                    System.out.println();
                    System.out.println(">>> 문장: " + script);
                    System.out.print("입력: ");
                    userInput = br.readLine();
                }

                System.out.println("✅ 정답!\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        long endTime = System.currentTimeMillis(); // 종료 시간
        long totalTime = (endTime - startTime) / 1000; // 초 단위 변환
        System.out.println("총 소요 시간: " + totalTime + "초");

        /* 설명. 회원 연동 후 랭킹 파일 업데이트 필요 */
    }

    /*
     * 타자 연습 실행 전 카운트 다운
     * */
    private static void countDown() {
        for (int i = 5; i >= 0; i--) {
            try {
                Thread.sleep(1000); // 1초 대기
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (i != 0) {
                System.out.println(i + "초 후 시작합니다!");
            } else {
                System.out.println("시작!");
            }
        }
    }
}
