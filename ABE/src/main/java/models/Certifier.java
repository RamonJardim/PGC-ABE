//package models;
//
//import java.math.BigInteger;
//import java.util.Map;
//
//import org.ethereum.crypto.ECKey;
//
//import sg.edu.ntu.sce.sands.crypto.dcpabe.AuthorityKeys;
//
///**
// * Certifier
// */
//public class Certifier extends User {
//
//    private AuthorityKeys authorityABEKeys;
//
//    public Certifier(String name, String userID, String email, Map<String, String> ECKeys, AuthorityKeys authorityABEKeys) {
//        super(name, email, ECKey.fromPrivate(new BigInteger(ECKeys.get("private"), 16)));
//        setAuthorityABEKeys(authorityABEKeys);
//    }
//
//    public Certifier(String name, String email, ECKey keys) {
//        super(name, email, keys);
//    }
//
//    public AuthorityKeys getAuthorityABEKeys() {
//        return authorityABEKeys;
//    }
//
//    public void setAuthorityABEKeys(AuthorityKeys authorityABEKeys) {
//        this.authorityABEKeys = authorityABEKeys;
//    }
//
//    public Certifier(User user) {
//        this(user.getName(), user.getEmail(), user.getECKeys());
//    }
//}