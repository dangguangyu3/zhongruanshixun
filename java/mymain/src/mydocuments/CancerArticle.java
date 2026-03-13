package mydocuments;

import java.util.ArrayList;

public class CancerArticle extends Category{
    private String title;
    private String content;
    private ArrayList<Author>authors;
    public CancerArticle(){
        cate="cancer";
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Article{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", authors=" + authors +
                ", cate='" + cate + '\'' +
                '}';
    }

    public CancerArticle(String title, String content, ArrayList<Author> authors) {
        this.cate="cancer";
        this.title = title;
        this.content = content;
        this.authors = authors;
    }
}

