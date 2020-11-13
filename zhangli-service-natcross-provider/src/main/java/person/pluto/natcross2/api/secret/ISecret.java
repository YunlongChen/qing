package person.pluto.natcross2.api.secret;

/**
 * <p>
 * 加密方法
 * </p>
 *
 * @author Pluto
 * @since 2020-01-08 16:01:28
 */
public interface ISecret {

    byte[] encrypt(byte[] content, int offset, int len) throws Exception;

    byte[] decrypt(byte[] result) throws Exception;

}
