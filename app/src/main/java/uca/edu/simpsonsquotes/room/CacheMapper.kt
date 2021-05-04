package uca.edu.simpsonsquotes.room

import uca.edu.simpsonsquotes.model.Quote
import uca.edu.simpsonsquotes.utils.EntityMapper
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<QuoteCacheEntity, Quote> {
    override fun mapFromEntity(entity: QuoteCacheEntity): Quote {
        return Quote(
            quote = entity.quote,
            character = entity.character,
            image = entity.image,
            characterDirection = entity.characterDirection
        )
    }

    override fun mapToEntity(domainModel: Quote): QuoteCacheEntity {
        return QuoteCacheEntity(
            id = 0, //check
            quote = domainModel.quote,
            character = domainModel.character,
            image = domainModel.image,
            characterDirection = domainModel.characterDirection
        )
    }

    fun mapFromEntityList(entities: List<QuoteCacheEntity>): List<Quote> {
        return entities.map { mapFromEntity(it) }
    }
}