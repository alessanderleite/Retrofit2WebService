package br.com.alessanderleite.retrofit2webservice.my_interface;

import br.com.alessanderleite.retrofit2webservice.model.NoticeList;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNoticeDataService {

    @GET("bins/1bsqcn/")
    Call<NoticeList> getNoticeData();
}
