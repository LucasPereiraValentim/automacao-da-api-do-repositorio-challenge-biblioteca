package br.com.lucas.testeapi.utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class APIUtils {

    public static Response post(String path, Object body) {
        return post(path, body);
    }

    public static Response get(String path) {
        return get(path);
    }

    public static Response delete(String path, Object body) {
        return delete(path, body);
    }

    public static void setContentTypeRequest(ContentType contentTypeRequest) {
        given().contentType(contentTypeRequest);
    }

    public static void setHeader(String parameter, String value) {
        given().headers(parameter, value);
    }
}
