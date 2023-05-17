import React, { useEffect } from 'react';
import { Link, useParams } from 'react-router-dom';
import { Button, Row, Col } from 'reactstrap';
import { Translate } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';
import { useAppDispatch, useAppSelector } from 'app/config/store';

import { getEntity } from './categorys.reducer';

export const CategorysDetail = () => {
  const dispatch = useAppDispatch();

  const { id } = useParams<'id'>();

  useEffect(() => {
    dispatch(getEntity(id));
  }, []);

  const categorysEntity = useAppSelector(state => state.categorys.entity);
  return (
    <Row>
      <Col md="8">
        <h2 data-cy="categorysDetailsHeading">
          <Translate contentKey="transotas1App.categorys.detail.title">Categorys</Translate>
        </h2>
        <dl className="jh-entity-details">
          <dt>
            <span id="id">
              <Translate contentKey="global.field.id">ID</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.id}</dd>
          <dt>
            <span id="categoria">
              <Translate contentKey="transotas1App.categorys.categoria">Categoria</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.categoria}</dd>
          <dt>
            <span id="extra1">
              <Translate contentKey="transotas1App.categorys.extra1">Extra 1</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra1}</dd>
          <dt>
            <span id="extra2">
              <Translate contentKey="transotas1App.categorys.extra2">Extra 2</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra2}</dd>
          <dt>
            <span id="extra3">
              <Translate contentKey="transotas1App.categorys.extra3">Extra 3</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra3}</dd>
          <dt>
            <span id="extra4">
              <Translate contentKey="transotas1App.categorys.extra4">Extra 4</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra4}</dd>
          <dt>
            <span id="extra5">
              <Translate contentKey="transotas1App.categorys.extra5">Extra 5</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra5}</dd>
          <dt>
            <span id="extra6">
              <Translate contentKey="transotas1App.categorys.extra6">Extra 6</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra6}</dd>
          <dt>
            <span id="extra7">
              <Translate contentKey="transotas1App.categorys.extra7">Extra 7</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra7}</dd>
          <dt>
            <span id="extra8">
              <Translate contentKey="transotas1App.categorys.extra8">Extra 8</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra8}</dd>
          <dt>
            <span id="extra9">
              <Translate contentKey="transotas1App.categorys.extra9">Extra 9</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra9}</dd>
          <dt>
            <span id="extra10">
              <Translate contentKey="transotas1App.categorys.extra10">Extra 10</Translate>
            </span>
          </dt>
          <dd>{categorysEntity.extra10}</dd>
        </dl>
        <Button tag={Link} to="/categorys" replace color="info" data-cy="entityDetailsBackButton">
          <FontAwesomeIcon icon="arrow-left" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.back">Back</Translate>
          </span>
        </Button>
        &nbsp;
        <Button tag={Link} to={`/categorys/${categorysEntity.id}/edit`} replace color="primary">
          <FontAwesomeIcon icon="pencil-alt" />{' '}
          <span className="d-none d-md-inline">
            <Translate contentKey="entity.action.edit">Edit</Translate>
          </span>
        </Button>
      </Col>
    </Row>
  );
};

export default CategorysDetail;
