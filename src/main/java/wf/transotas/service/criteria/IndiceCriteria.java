package wf.transotas.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import org.springdoc.api.annotations.ParameterObject;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.*;

/**
 * Criteria class for the {@link wf.transotas.domain.Indice} entity. This class is used
 * in {@link wf.transotas.web.rest.IndiceResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /indices?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
@ParameterObject
@SuppressWarnings("common-java:DuplicatedBlocks")
public class IndiceCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter img;

    private StringFilter titulo;

    private StringFilter url;

    private StringFilter autor;

    private InstantFilter fecha;

    private StringFilter ciudad;

    private StringFilter estado;

    private StringFilter pais;

    private IntegerFilter comentarios;

    private IntegerFilter vistas;

    private IntegerFilter rating;

    private StringFilter extra1;

    private StringFilter extra2;

    private StringFilter extra3;

    private StringFilter extra4;

    private StringFilter extra5;

    private StringFilter extra6;

    private StringFilter extra7;

    private StringFilter extra8;

    private StringFilter extra9;

    private StringFilter extra10;

    private Boolean distinct;

    public IndiceCriteria() {}

    public IndiceCriteria(IndiceCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.img = other.img == null ? null : other.img.copy();
        this.titulo = other.titulo == null ? null : other.titulo.copy();
        this.url = other.url == null ? null : other.url.copy();
        this.autor = other.autor == null ? null : other.autor.copy();
        this.fecha = other.fecha == null ? null : other.fecha.copy();
        this.ciudad = other.ciudad == null ? null : other.ciudad.copy();
        this.estado = other.estado == null ? null : other.estado.copy();
        this.pais = other.pais == null ? null : other.pais.copy();
        this.comentarios = other.comentarios == null ? null : other.comentarios.copy();
        this.vistas = other.vistas == null ? null : other.vistas.copy();
        this.rating = other.rating == null ? null : other.rating.copy();
        this.extra1 = other.extra1 == null ? null : other.extra1.copy();
        this.extra2 = other.extra2 == null ? null : other.extra2.copy();
        this.extra3 = other.extra3 == null ? null : other.extra3.copy();
        this.extra4 = other.extra4 == null ? null : other.extra4.copy();
        this.extra5 = other.extra5 == null ? null : other.extra5.copy();
        this.extra6 = other.extra6 == null ? null : other.extra6.copy();
        this.extra7 = other.extra7 == null ? null : other.extra7.copy();
        this.extra8 = other.extra8 == null ? null : other.extra8.copy();
        this.extra9 = other.extra9 == null ? null : other.extra9.copy();
        this.extra10 = other.extra10 == null ? null : other.extra10.copy();
        this.distinct = other.distinct;
    }

    @Override
    public IndiceCriteria copy() {
        return new IndiceCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getImg() {
        return img;
    }

    public StringFilter img() {
        if (img == null) {
            img = new StringFilter();
        }
        return img;
    }

    public void setImg(StringFilter img) {
        this.img = img;
    }

    public StringFilter getTitulo() {
        return titulo;
    }

    public StringFilter titulo() {
        if (titulo == null) {
            titulo = new StringFilter();
        }
        return titulo;
    }

    public void setTitulo(StringFilter titulo) {
        this.titulo = titulo;
    }

    public StringFilter getUrl() {
        return url;
    }

    public StringFilter url() {
        if (url == null) {
            url = new StringFilter();
        }
        return url;
    }

    public void setUrl(StringFilter url) {
        this.url = url;
    }

    public StringFilter getAutor() {
        return autor;
    }

    public StringFilter autor() {
        if (autor == null) {
            autor = new StringFilter();
        }
        return autor;
    }

    public void setAutor(StringFilter autor) {
        this.autor = autor;
    }

    public InstantFilter getFecha() {
        return fecha;
    }

    public InstantFilter fecha() {
        if (fecha == null) {
            fecha = new InstantFilter();
        }
        return fecha;
    }

    public void setFecha(InstantFilter fecha) {
        this.fecha = fecha;
    }

    public StringFilter getCiudad() {
        return ciudad;
    }

    public StringFilter ciudad() {
        if (ciudad == null) {
            ciudad = new StringFilter();
        }
        return ciudad;
    }

    public void setCiudad(StringFilter ciudad) {
        this.ciudad = ciudad;
    }

    public StringFilter getEstado() {
        return estado;
    }

    public StringFilter estado() {
        if (estado == null) {
            estado = new StringFilter();
        }
        return estado;
    }

    public void setEstado(StringFilter estado) {
        this.estado = estado;
    }

    public StringFilter getPais() {
        return pais;
    }

    public StringFilter pais() {
        if (pais == null) {
            pais = new StringFilter();
        }
        return pais;
    }

    public void setPais(StringFilter pais) {
        this.pais = pais;
    }

    public IntegerFilter getComentarios() {
        return comentarios;
    }

    public IntegerFilter comentarios() {
        if (comentarios == null) {
            comentarios = new IntegerFilter();
        }
        return comentarios;
    }

    public void setComentarios(IntegerFilter comentarios) {
        this.comentarios = comentarios;
    }

    public IntegerFilter getVistas() {
        return vistas;
    }

    public IntegerFilter vistas() {
        if (vistas == null) {
            vistas = new IntegerFilter();
        }
        return vistas;
    }

    public void setVistas(IntegerFilter vistas) {
        this.vistas = vistas;
    }

    public IntegerFilter getRating() {
        return rating;
    }

    public IntegerFilter rating() {
        if (rating == null) {
            rating = new IntegerFilter();
        }
        return rating;
    }

    public void setRating(IntegerFilter rating) {
        this.rating = rating;
    }

    public StringFilter getExtra1() {
        return extra1;
    }

    public StringFilter extra1() {
        if (extra1 == null) {
            extra1 = new StringFilter();
        }
        return extra1;
    }

    public void setExtra1(StringFilter extra1) {
        this.extra1 = extra1;
    }

    public StringFilter getExtra2() {
        return extra2;
    }

    public StringFilter extra2() {
        if (extra2 == null) {
            extra2 = new StringFilter();
        }
        return extra2;
    }

    public void setExtra2(StringFilter extra2) {
        this.extra2 = extra2;
    }

    public StringFilter getExtra3() {
        return extra3;
    }

    public StringFilter extra3() {
        if (extra3 == null) {
            extra3 = new StringFilter();
        }
        return extra3;
    }

    public void setExtra3(StringFilter extra3) {
        this.extra3 = extra3;
    }

    public StringFilter getExtra4() {
        return extra4;
    }

    public StringFilter extra4() {
        if (extra4 == null) {
            extra4 = new StringFilter();
        }
        return extra4;
    }

    public void setExtra4(StringFilter extra4) {
        this.extra4 = extra4;
    }

    public StringFilter getExtra5() {
        return extra5;
    }

    public StringFilter extra5() {
        if (extra5 == null) {
            extra5 = new StringFilter();
        }
        return extra5;
    }

    public void setExtra5(StringFilter extra5) {
        this.extra5 = extra5;
    }

    public StringFilter getExtra6() {
        return extra6;
    }

    public StringFilter extra6() {
        if (extra6 == null) {
            extra6 = new StringFilter();
        }
        return extra6;
    }

    public void setExtra6(StringFilter extra6) {
        this.extra6 = extra6;
    }

    public StringFilter getExtra7() {
        return extra7;
    }

    public StringFilter extra7() {
        if (extra7 == null) {
            extra7 = new StringFilter();
        }
        return extra7;
    }

    public void setExtra7(StringFilter extra7) {
        this.extra7 = extra7;
    }

    public StringFilter getExtra8() {
        return extra8;
    }

    public StringFilter extra8() {
        if (extra8 == null) {
            extra8 = new StringFilter();
        }
        return extra8;
    }

    public void setExtra8(StringFilter extra8) {
        this.extra8 = extra8;
    }

    public StringFilter getExtra9() {
        return extra9;
    }

    public StringFilter extra9() {
        if (extra9 == null) {
            extra9 = new StringFilter();
        }
        return extra9;
    }

    public void setExtra9(StringFilter extra9) {
        this.extra9 = extra9;
    }

    public StringFilter getExtra10() {
        return extra10;
    }

    public StringFilter extra10() {
        if (extra10 == null) {
            extra10 = new StringFilter();
        }
        return extra10;
    }

    public void setExtra10(StringFilter extra10) {
        this.extra10 = extra10;
    }

    public Boolean getDistinct() {
        return distinct;
    }

    public void setDistinct(Boolean distinct) {
        this.distinct = distinct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final IndiceCriteria that = (IndiceCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(img, that.img) &&
            Objects.equals(titulo, that.titulo) &&
            Objects.equals(url, that.url) &&
            Objects.equals(autor, that.autor) &&
            Objects.equals(fecha, that.fecha) &&
            Objects.equals(ciudad, that.ciudad) &&
            Objects.equals(estado, that.estado) &&
            Objects.equals(pais, that.pais) &&
            Objects.equals(comentarios, that.comentarios) &&
            Objects.equals(vistas, that.vistas) &&
            Objects.equals(rating, that.rating) &&
            Objects.equals(extra1, that.extra1) &&
            Objects.equals(extra2, that.extra2) &&
            Objects.equals(extra3, that.extra3) &&
            Objects.equals(extra4, that.extra4) &&
            Objects.equals(extra5, that.extra5) &&
            Objects.equals(extra6, that.extra6) &&
            Objects.equals(extra7, that.extra7) &&
            Objects.equals(extra8, that.extra8) &&
            Objects.equals(extra9, that.extra9) &&
            Objects.equals(extra10, that.extra10) &&
            Objects.equals(distinct, that.distinct)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(
            id,
            img,
            titulo,
            url,
            autor,
            fecha,
            ciudad,
            estado,
            pais,
            comentarios,
            vistas,
            rating,
            extra1,
            extra2,
            extra3,
            extra4,
            extra5,
            extra6,
            extra7,
            extra8,
            extra9,
            extra10,
            distinct
        );
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "IndiceCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (img != null ? "img=" + img + ", " : "") +
            (titulo != null ? "titulo=" + titulo + ", " : "") +
            (url != null ? "url=" + url + ", " : "") +
            (autor != null ? "autor=" + autor + ", " : "") +
            (fecha != null ? "fecha=" + fecha + ", " : "") +
            (ciudad != null ? "ciudad=" + ciudad + ", " : "") +
            (estado != null ? "estado=" + estado + ", " : "") +
            (pais != null ? "pais=" + pais + ", " : "") +
            (comentarios != null ? "comentarios=" + comentarios + ", " : "") +
            (vistas != null ? "vistas=" + vistas + ", " : "") +
            (rating != null ? "rating=" + rating + ", " : "") +
            (extra1 != null ? "extra1=" + extra1 + ", " : "") +
            (extra2 != null ? "extra2=" + extra2 + ", " : "") +
            (extra3 != null ? "extra3=" + extra3 + ", " : "") +
            (extra4 != null ? "extra4=" + extra4 + ", " : "") +
            (extra5 != null ? "extra5=" + extra5 + ", " : "") +
            (extra6 != null ? "extra6=" + extra6 + ", " : "") +
            (extra7 != null ? "extra7=" + extra7 + ", " : "") +
            (extra8 != null ? "extra8=" + extra8 + ", " : "") +
            (extra9 != null ? "extra9=" + extra9 + ", " : "") +
            (extra10 != null ? "extra10=" + extra10 + ", " : "") +
            (distinct != null ? "distinct=" + distinct + ", " : "") +
            "}";
    }
}
