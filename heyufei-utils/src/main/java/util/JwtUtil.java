package util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data
@Component
@ConfigurationProperties("jwt.config") //从application.yml中得到key和ttl值
public class JwtUtil {
    private String key;
    private long ttl;//过期时间


    /**
     * 生成JWT
     * @param mobile   user.mobile 或者 admin.mobile
     * @param username user.name 或者 admin.name
     * @param roles "user"或者"admin"
     */
    public String createJWT(String mobile, String username, String roles) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder().setId(mobile)
                .setSubject(username)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, key)
                .claim("roles", roles);
        if (ttl > 0) {
            builder.setExpiration(new Date(nowMillis + ttl));
        }
        return builder.compact();
    }

    /**
     * 解析JWT
     *
     * @param jwtStr
     * @return 返回的就是加入的那三个值 userid，username，"user"或者"admin"
     *  claims.getId()   claims.getSubject()  claims.getIssuedAt()
     */
    public Claims parseJWT(String jwtStr) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(jwtStr).getBody();
    }



}
