package ingenieria.seguridad.software.trabajo_seguridad.data.services;

import ingenieria.seguridad.software.trabajo_seguridad.data.models.Nrc;

public interface INrcService extends IServices<Nrc> {

    Nrc findByNrc(String nrc);

}
