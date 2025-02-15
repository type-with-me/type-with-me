package script.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import script.repository.ScriptRepository;

public class ScriptService {
    private static final ScriptRepository scriptsRepository = new ScriptRepository();

    public List<String> getFiveRandomScripts() {
        List<String> allScripts = scriptsRepository.selectAllScripts();

        Collections.shuffle(allScripts); // 문장 섞기

        return IntStream.range(0, 5)
                .mapToObj(allScripts::get)
                .collect(Collectors.toList());
    }

}
