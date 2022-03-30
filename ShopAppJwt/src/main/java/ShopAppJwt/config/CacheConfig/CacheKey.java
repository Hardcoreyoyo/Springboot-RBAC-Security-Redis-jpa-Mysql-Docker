package ShopAppJwt.config.CacheConfig;

import lombok.Data;

@Data
public class CacheKey {

    // 用戶信息緩存(用於JWT用戶登錄驗證及接口權限驗證)，緩存策略：key=用戶名
    // 用戶信息被修改、刪除、重置修改密碼的時候，清除該緩存。緩存清除策略：key=用戶名
    public static final String USER_DETAIL = "user_detail";


    // 某個用戶角色列表信息緩存，緩存策略：key=用戶名
    // 角色被修改或刪除或角色禁用狀態被更新的時候，清除所有用戶的角色列表緩存信息
    // 某個用戶被重新分配角色的時候，清除該用戶的角色列表緩存信息,，緩存清除策略：key=用戶名
    public static final String ROLE_CODES = "role_codes";


    // 某個角色可以訪問的 Url 列表的緩存，緩存策略：key=roleCode
    // Url 被修改或刪除或禁用狀態被更新的時候，清除所有角色對應的 Url 緩存數據
    // 某個角色被重新分配 Url 權限的時候，清除該角色對應的 Url 權限緩存信息,緩存清除策略：key=roleCode
    public static final String API_URLS = "api_urls";
}
