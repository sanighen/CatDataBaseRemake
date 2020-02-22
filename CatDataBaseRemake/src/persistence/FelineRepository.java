package persistence;

import data.Cat;
import data.FelineInterface;

import java.util.ArrayList;
import java.util.List;

public class FelineRepository implements FelineRepositoryInterface {
	private List<FelineInterface> felines;

	public FelineRepository() {
		felines = new ArrayList<>();
	}

	@Override
	public boolean save(FelineInterface feline) {
		if (!update(feline))  // Если не удалось заапдейтить то добавь новый элемент списка
			felines.add(feline);
		return true;
	}

	@Override
	public boolean delete(FelineInterface feline) {
		for (FelineInterface f : felines) {
			if (feline.getId().equals(f.getId())) {
				felines.remove(felines.indexOf(f));
				return true;
			}
		}
		
		return false;
	}

	@Override
	public boolean update(FelineInterface feline) {
		for (FelineInterface oneFeline : felines) {
			if (feline.getId().equals(oneFeline.getId())) {
				felines.set(felines.indexOf(oneFeline), feline);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<FelineInterface> findAll() throws CloneNotSupportedException {
		List<FelineInterface> cloneFelines = new ArrayList<>();
		for (FelineInterface feline : felines) {
			Cat cat = (Cat) feline;
			cloneFelines.add(cat.clone());
		}
		return cloneFelines;
	}

	@Override
	public FelineInterface findById(Integer id) throws CloneNotSupportedException {
		for (FelineInterface feline : felines) {
			if (feline.getId().equals(id)) {
				return feline.clone();
			}
		}
		return null;
	}

	public List<FelineInterface> findByName(String name) throws CloneNotSupportedException {
		List<FelineInterface> cloneNames = new ArrayList<>();
		for (FelineInterface feline : felines) {
			if (feline.getName().equals(name)) {
				cloneNames.add(feline.clone());
			}
		}
		return cloneNames;
	}

	public List<FelineInterface> findByRace(String race) throws CloneNotSupportedException {
		List<FelineInterface> cloneRaces = new ArrayList<>();
		for (FelineInterface feline : felines) {
			if (feline.getRace().equals(race)) {
				cloneRaces.add(feline.clone());
			}
		}
		return cloneRaces;
	}

	// For testing
	// Fill the list with data
	public void generate() {
		felines.add(new Cat(1, "Барсик", "Шотландская", 2019));
		felines.add(new Cat(2, "Мурзик", "Британская", 2017));
		felines.add(new Cat(3, "Шурсик", "Персидская", 2018));
		felines.add(new Cat(4, "Шурсик", "Египетская", 2015));
		felines.add(new Cat(5, "Шурсик", "Перидская", 2016));
		felines.add(new Cat(6, "Шурсик", "Персидская", 2013));
		
	}
}