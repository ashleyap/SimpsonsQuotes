package uca.edu.simpsonsquotes.retrofit

import uca.edu.simpsonsquotes.model.Quote
import uca.edu.simpsonsquotes.utils.EntityMapper
import java.util.*
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<QuoteNetworkEntity, Quote>{
    override fun mapFromEntity(entity: QuoteNetworkEntity): Quote {
        return Quote(
            id = UUID.randomUUID().toString(),
            quote = entity.quote,
            character = entity.character,
            image = entity.image,
            characterDirection = entity.characterDirection
        )
    }

    override fun mapToEntity(domainModel: Quote): QuoteNetworkEntity {
        return QuoteNetworkEntity(
            id = domainModel.id,
            quote = domainModel.quote,
            character = domainModel.character,
            image = domainModel.image,
            characterDirection = domainModel.characterDirection
        )
    }

    fun mapFromEntityList(entities: List<QuoteNetworkEntity>): List<Quote>{
        return entities.map { mapFromEntity(it) }
    }
}