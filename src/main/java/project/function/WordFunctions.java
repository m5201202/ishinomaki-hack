package project.function;

import javax.inject.Inject;
import java.util.List;

public class WordFunctions
    @Inject
            APIAccess apiAccess;
    WordFunctions(){}
    public String[] JSONwordList(String json){
        String[] result = json.split(":");
        System.out.println(result[2]);
        String re = result[2].replaceAll("\"","");
        re = re.replaceAll("]","");
        re = re.replaceAll("\\[","");
        re = re.replaceAll("\\}","");
        System.out.println(re);
        result = re.split(",");
        return result;
    }
    public String revertString(String[] input){

    }
    public String createNewIdea(String idea){
        String[] wordList = null;
        try{wordList = JSONwordList(apiAccess.post(idea));}
        catch (Exception e){}
        return revertString(wordList);
    }
    public static void main(String args[]){
        WordFunctions test = new WordFunctions();
        String[] testresult = test.JSONwordList("{\"request_id\":\"labs.goo.ne.jp\\t1534573052\\t0\",\"word_list\":[[[\"今日\",\"名詞\",\"キョウ\"],[\"の\",\"格助詞\",\"ノ\"],[\"天気\",\"名詞\",\"テンキ\"],[\"は\",\"連用助詞\",\"ハ\"],[\"晴れ\",\"名詞\",\"ハレ\"]]]}");
        for(int i=0;i<testresult.length;i+=3)
            System.out.println(testresult[i]);
    }

}
