#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.services;

import ${package}.converter.DozerConverter;
import ${package}.data.vo.v1.PersonVO;
import ${package}.exception.ResourceNotFoundException;
import ${package}.data.model.Person;
import ${package}.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person) {
        Person entity = DozerConverter.parseObject(person, Person.class);
        PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public Page<PersonVO> findPersonByName(String firstName, Pageable pageable) {
        var page = repository.findPersonByName(firstName, pageable);
        return page.map(this::convertToPersonVO);
    }

    public Page<PersonVO> findAll(Pageable pageable) {
        var page = repository.findAll(pageable);
        return page.map(this::convertToPersonVO);
    }

    private PersonVO convertToPersonVO(Person entity) {
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO findById(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person) {
        Person entity = repository.findById(person.getKey())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        PersonVO vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    // @Transactional Garantir a consistência das informações (ACID)
    @Transactional
    public PersonVO disablePerson(Long id) {
        repository.disablePersons(id);

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public void delete(Long id) {
        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

}
