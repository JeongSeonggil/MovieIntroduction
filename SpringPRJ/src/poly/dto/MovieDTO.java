package poly.dto;

public class MovieDTO {
    private String movie_code; // 영화 code / 식별 value
    private String movie_title; // 영화 제목
    private String movie_comment; // 영화 댓글
    private String movie_analysis; // 오피니언 마이닝 결과
    private String movie_type;
    private String exists_yn; // 영화 중복 확인 Columns (X)

    public String getMovie_code() {
        return movie_code;
    }

    public void setMovie_code(String movie_code) {
        this.movie_code = movie_code;
    }

    public String getMovie_title() {
        return movie_title;
    }

    public void setMovie_title(String movie_title) {
        this.movie_title = movie_title;
    }

    public String getMovie_comment() {
        return movie_comment;
    }

    public void setMovie_comment(String movie_comment) {
        this.movie_comment = movie_comment;
    }

    public String getMovie_analysis() {
        return movie_analysis;
    }

    public void setMovie_analysis(String movie_analysis) {
        this.movie_analysis = movie_analysis;
    }

    public String getMovie_type() {
        return movie_type;
    }

    public void setMovie_type(String movie_type) {
        this.movie_type = movie_type;
    }

    public String getExists_yn() {
        return exists_yn;
    }

    public void setExists_yn(String exists_yn) {
        this.exists_yn = exists_yn;
    }
}
