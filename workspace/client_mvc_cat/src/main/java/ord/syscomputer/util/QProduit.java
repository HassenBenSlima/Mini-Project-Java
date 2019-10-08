/*package ord.syscomputer.util;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

import ord.syscomputer.entities.Produit;


*//**
 * QProduit is a Querydsl query type for Produit
 *//*
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduit extends EntityPathBase<Produit> {

    private static final long serialVersionUID = 712578191L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduit produit = new QProduit("produit");

    public final QCategorie categorie;

    public final StringPath designation = createString("designation");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> prix = createNumber("prix", Double.class);

    public final NumberPath<Integer> quantite = createNumber("quantite", Integer.class);

    public QProduit(String variable) {
        this(Produit.class, forVariable(variable), INITS);
    }

    public QProduit(Path<? extends Produit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduit(PathMetadata metadata, PathInits inits) {
        this(Produit.class, metadata, inits);
    }

    public QProduit(Class<? extends Produit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.categorie = inits.isInitialized("categorie") ? new QCategorie(forProperty("categorie")) : null;
    }

}

*/