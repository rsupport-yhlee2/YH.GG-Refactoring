package yunho.app.lolapitest.lolAPI

import com.example.yhgg_refactoring.data.response.LeagueEntryResponse
import com.example.yhgg_refactoring.data.response.LeagueListResponse
import com.example.yhgg_refactoring.data.response.MatchResponse
import com.example.yhgg_refactoring.data.response.SummonerResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

//롤 API 사용을 위한 인터페이스
//함수 더욱 추가 예정
interface lolAPIService {
    //소환사 이름을 기준으로 검색하는 함수
    @GET("/lol/summoner/v4/summoners/by-name/{summonerName}")
    fun getSummonerInfoByName(
        @Path("summonerName") SummonerName: String,
        @Query("api_key") APIKey : String
    ): Single<SummonerResponse>
    //소환사의 암호화된 아이디를 기준으로 소환사 상세정보를 가져오는 함수
    //반환형이 list<DTO> 이므로 리스트형으로 반환해준다
    @GET("/lol/league/v4/entries/by-summoner/{encryptedSummonerId}")
    fun getSummonerEntriesByEncryptedSummonerID(
        @Path("encryptedSummonerId") encryptedSummonerId : String,
        @Query("api_key") APIKey : String
    ): Single<List<LeagueEntryResponse>>
    @GET("/lol/league/v4/leagues/{leagueId}")
    fun getLeagueByGivenID(
        @Path("leagueId") leagueID : String,
        @Query("api_key") APIKey : String
    ): Single<LeagueListResponse>


    //매치정보를 불러오는 함수들은 LOLAPIForMatch를 사용하여 호출
    @GET("/lol/match/v5/matches/by-puuid/{puuid}/ids")
    fun getMatchIdBypuuid(
        @Path("puuid") puuid :String,
        @Query("start") start : Int,
        @Query("count") count : Int,
        @Query("api_key") APIKey : String,
    ): Single<List<String>>
    //매치 아이디를 통해 매치 상세정보를 불러오는 함수
    @GET("/lol/match/v5/matches/{matchId}")
    fun getMatchInfoByMatchID(
        @Path("matchId") MatchId: String,
        @Query("api_key") APIKey : String
    ): Single<MatchResponse>
}