import reportes from 'app/entities/reportes/reportes.reducer';
import casoText from 'app/entities/caso-text/caso-text.reducer';
import categorys from 'app/entities/categorys/categorys.reducer';
import comentarios from 'app/entities/comentarios/comentarios.reducer';
import informacion from 'app/entities/informacion/informacion.reducer';
import indiceOriginal from 'app/entities/indice-original/indice-original.reducer';
import indice from 'app/entities/indice/indice.reducer';
/* jhipster-needle-add-reducer-import - JHipster will add reducer here */

const entitiesReducers = {
  reportes,
  casoText,
  categorys,
  comentarios,
  informacion,
  indiceOriginal,
  indice,
  /* jhipster-needle-add-reducer-combine - JHipster will add reducer here */
};

export default entitiesReducers;
