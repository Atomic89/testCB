package igm;

import lombok.*;

/**
 * Информация по организации
 * @author NikolaevSA
 */
@Getter
@Setter
public class OrgInsurInfo {
    /**
     * Инн организации
     */
    private String inn;
    /**
     * Огрн организации
     */
    private String ogrn;
    /**
     * Полное название организации
     */
    private String name;
    /**
     * Адрес организации
     */
    private String address;
}
