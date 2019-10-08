/*package ord.syscomputer.util;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;

import ord.syscomputer.entities.Categorie;
import ord.syscomputer.entities.Produit;


*//**
 * QCategorie is a Querydsl query type for Categorie
 *//*
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCategorie extends EntityPathBase<Categorie> {

    private static final long serialVersionUID = 210372253L;

    public static final QCategorie categorie = new QCategorie("categorie");

    public final NumberPath<Long> idCategorie = createNumber("idCategorie", Long.class);

    public final StringPath nomCategorie = createString("nomCategorie");

    public final CollectionPath<Produit, QProduit> produits = this.<Produit, QProduit>createCollection("produits", Produit.class, QProduit.class, PathInits.DIRECT2);

    public QCategorie(String variable) {
        super(Categorie.class, forVariable(variable));
    }

    public QCategorie(Path<? extends Categorie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCategorie(PathMetadata metadata) {
        super(Categorie.class, metadata);
    }

}

*/