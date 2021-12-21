package poly.dto;

public class MovieDTO {
    private String movie_seq; // 영화 seq
    private String movie_code; // 영화 code / 식별 value
    private String movie_title; // 영화 제목
    private String movie_comment; // 영화 댓글
    private String movie_analysis; // 오피니언 마이닝 결과
    private String movie_rating; // 영화 등수
    private String movie_img; // 영화 사진 저장 경로
    private String exists_yn; // 영화 중복 확인 Columns (X)

    public String getMovie_seq() {
        return movie_seq;
    }

    public void setMovie_seq(String movie_seq) {
        this.movie_seq = movie_seq;
    }

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

    public String getMovie_rating() {
        return movie_rating;
    }

    public void setMovie_rating(String movie_rating) {
        this.movie_rating = movie_rating;
    }

    public String getMovie_img() {
        return movie_img;
    }

    public void setMovie_img(String movie_img) {
        this.movie_img = movie_img;
    }

    public String getExists_yn() {
        return exists_yn;
    }

    public void setExists_yn(String exists_yn) {
        this.exists_yn = exists_yn;
    }
}
