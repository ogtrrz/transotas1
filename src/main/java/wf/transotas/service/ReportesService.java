package wf.transotas.service;

import static org.elasticsearch.index.query.QueryBuilders.*;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.jhipster.service.filter.StringFilter;
import wf.transotas.domain.Informacion;
import wf.transotas.domain.Reportes;
import wf.transotas.repository.ReportesRepository;
import wf.transotas.repository.search.ReportesSearchRepository;
import wf.transotas.service.criteria.CategorysCriteria;
import wf.transotas.service.dto.CasoTextDTO;
import wf.transotas.service.dto.CategorysDTO;
import wf.transotas.service.dto.InformacionDTO;
import wf.transotas.service.dto.ReportesDTO;
import wf.transotas.service.mapper.ReportesMapper;

/**
 * Service Implementation for managing {@link Reportes}.
 */
@Service
@Transactional
public class ReportesService {

    private final Logger log = LoggerFactory.getLogger(ReportesService.class);

    private final ReportesRepository reportesRepository;

    private final ReportesMapper reportesMapper;

    private final ReportesSearchRepository reportesSearchRepository;

    private final InformacionService informacionService;

    private final CasoTextService casoTextService;

    private final CategorysQueryService categorysQueryService;

    public ReportesService(
        ReportesRepository reportesRepository,
        ReportesMapper reportesMapper,
        ReportesSearchRepository reportesSearchRepository,
        InformacionService informacionService,
        CasoTextService casoTextService,
        CategorysQueryService categorysQueryService
    ) {
        this.reportesRepository = reportesRepository;
        this.reportesMapper = reportesMapper;
        this.reportesSearchRepository = reportesSearchRepository;
        this.informacionService = informacionService;
        this.casoTextService = casoTextService;
        this.categorysQueryService = categorysQueryService;
    }

    /**
     * Save a reportes.
     *
     * @param reportesDTO the entity to save.
     * @return the persisted entity.
     */

    //TODO en el post agregar informacion en 0 automatico y agregar el caso
    public ReportesDTO save(ReportesDTO reportesDTO) {
        log.debug("Request to save Reportes : {}", reportesDTO);
        InformacionDTO informacionDto = new InformacionDTO();
        informacionDto.setComentarios(0);
        informacionDto.setVistas(0);
        informacionDto.setRating(0);
        informacionDto = informacionService.save(informacionDto);
        reportesDTO.setInformacion(informacionDto);

        CasoTextDTO casoTextDTO = new CasoTextDTO();
        casoTextDTO.setDescripcion(reportesDTO.getCasoText().getDescripcion());
        casoTextDTO = casoTextService.save(casoTextDTO);
        reportesDTO.setCasoText(casoTextDTO);

        //        citeria
        Set<CategorysDTO> categorys = reportesDTO.getCategorys();
        Set<CategorysDTO> categorysId = categorys
            .stream()
            .map(item -> {
                StringFilter stringFilter = new StringFilter();
                stringFilter.setEquals(item.getCategoria());
                CategorysCriteria criteria = new CategorysCriteria();
                criteria.setCategoria(stringFilter);
                List<CategorysDTO> listCategorysDTO = categorysQueryService.findByCriteria(criteria);
                if (listCategorysDTO.stream().findFirst().isPresent()) {
                    return listCategorysDTO.stream().findFirst().get();
                }
                return null;
            })
            .filter(x -> x != null)
            .collect(Collectors.toSet());
        reportesDTO.setCategorys(categorysId);
        Reportes reportes = reportesMapper.toEntity(reportesDTO);

        reportes = reportesRepository.save(reportes);
        ReportesDTO result = reportesMapper.toDto(reportes);
        reportesSearchRepository.index(reportes);
        return result;
    }

    /**
     * Update a reportes.
     *
     * @param reportesDTO the entity to save.
     * @return the persisted entity.
     */
    public ReportesDTO update(ReportesDTO reportesDTO) {
        log.debug("Request to update Reportes : {}", reportesDTO);
        Reportes reportes = reportesMapper.toEntity(reportesDTO);
        reportes = reportesRepository.save(reportes);
        ReportesDTO result = reportesMapper.toDto(reportes);
        reportesSearchRepository.index(reportes);
        return result;
    }

    /**
     * Partially update a reportes.
     *
     * @param reportesDTO the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<ReportesDTO> partialUpdate(ReportesDTO reportesDTO) {
        log.debug("Request to partially update Reportes : {}", reportesDTO);

        return reportesRepository
            .findById(reportesDTO.getId())
            .map(existingReportes -> {
                reportesMapper.partialUpdate(existingReportes, reportesDTO);

                return existingReportes;
            })
            .map(reportesRepository::save)
            .map(savedReportes -> {
                reportesSearchRepository.save(savedReportes);

                return savedReportes;
            })
            .map(reportesMapper::toDto);
    }

    /**
     * Get all the reportes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ReportesDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Reportes");
        return reportesRepository.findAll(pageable).map(reportesMapper::toDto);
    }

    /**
     * Get all the reportes with eager load of many-to-many relationships.
     *
     * @return the list of entities.
     */
    public Page<ReportesDTO> findAllWithEagerRelationships(Pageable pageable) {
        return reportesRepository.findAllWithEagerRelationships(pageable).map(reportesMapper::toDto);
    }

    /**
     * Get one reportes by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<ReportesDTO> findOne(Long id) {
        log.debug("Request to get Reportes : {}", id);
        return reportesRepository.findOneWithEagerRelationships(id).map(reportesMapper::toDto);
    }

    /**
     * Delete the reportes by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Reportes : {}", id);
        reportesRepository.deleteById(id);
        reportesSearchRepository.deleteById(id);
    }

    /**
     * Search for the reportes corresponding to the query.
     *
     * @param query the query of the search.
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<ReportesDTO> search(String query, Pageable pageable) {
        log.debug("Request to search for a page of Reportes for query {}", query);
        return reportesSearchRepository.search(query, pageable).map(reportesMapper::toDto);
    }
}
