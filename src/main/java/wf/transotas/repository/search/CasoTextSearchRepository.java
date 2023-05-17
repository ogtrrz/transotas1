package wf.transotas.repository.search;

import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.util.List;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.elasticsearch.search.sort.SortBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import wf.transotas.domain.CasoText;
import wf.transotas.repository.CasoTextRepository;

/**
 * Spring Data Elasticsearch repository for the {@link CasoText} entity.
 */
public interface CasoTextSearchRepository extends ElasticsearchRepository<CasoText, Long>, CasoTextSearchRepositoryInternal {}

interface CasoTextSearchRepositoryInternal {
    Page<CasoText> search(String query, Pageable pageable);

    Page<CasoText> search(Query query);

    void index(CasoText entity);
}

class CasoTextSearchRepositoryInternalImpl implements CasoTextSearchRepositoryInternal {

    private final ElasticsearchRestTemplate elasticsearchTemplate;
    private final CasoTextRepository repository;

    CasoTextSearchRepositoryInternalImpl(ElasticsearchRestTemplate elasticsearchTemplate, CasoTextRepository repository) {
        this.elasticsearchTemplate = elasticsearchTemplate;
        this.repository = repository;
    }

    @Override
    public Page<CasoText> search(String query, Pageable pageable) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        return search(nativeSearchQuery.setPageable(pageable));
    }

    @Override
    public Page<CasoText> search(Query query) {
        SearchHits<CasoText> searchHits = elasticsearchTemplate.search(query, CasoText.class);
        List<CasoText> hits = searchHits.map(SearchHit::getContent).stream().collect(Collectors.toList());
        return new PageImpl<>(hits, query.getPageable(), searchHits.getTotalHits());
    }

    @Override
    public void index(CasoText entity) {
        repository.findById(entity.getId()).ifPresent(elasticsearchTemplate::save);
    }
}
