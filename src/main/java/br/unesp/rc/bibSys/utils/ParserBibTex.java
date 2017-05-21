package br.unesp.rc.bibSys.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.HashMap;
import java.util.Map;

public final class ParserBibTex {

    private static final int _lengthNormalizer = 16;
    
    private static <T> String objectToJson (T objeto){
        Gson gson = new Gson();
        return gson.toJson(objeto);
    }
    
    public static <T> String jsonToBibTex(T objeto){
        String strJson = ParserBibTex.objectToJson(objeto);
        
        //Converte em objeto Dictionary
        Map<String, String> jsonDictionary = new Gson().fromJson(strJson, new TypeToken<HashMap<String, String>>() {}.getType());
        
        return dictionaryToText(jsonDictionary);
    }

    private static String dictionaryToText(Map<String, String> dictionary) {
        StringBuilder result = new StringBuilder();
        
        //Insere o tipo da referência. Exemplo: @ARTICLE
        result.append("@").append(dictionary.get("tipoReferencia")).append("{");
        //Insere o nome da referencia
        result.append(dictionary.get("bibKey")).append(",");
        
        dictionary.remove("tipoReferencia");
        dictionary.remove("bibKey");
        result.append(System.getProperty("line.separator"));
        
        dictionary.forEach((k,v) -> {
            String keyTag = normalizeKeyTag(k);
            result.append("  ").append(keyTag).append("{").append(v).append("},").append(System.getProperty("line.separator"));
        });
        
        result.append("}");
        System.out.println(result.toString());
        return result.toString();
    }

    private static String normalizeKeyTag(String key) {
        StringBuilder result = new StringBuilder();
        
        int whiteSpaces = _lengthNormalizer - key.length();
        result.append(key).append(String.format("%"+whiteSpaces+"s", "")).append("= ");
        return result.toString();
    }
}
