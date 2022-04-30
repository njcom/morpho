inventory-file-path := $(CURDIR)/inventory.yml
ansible := ansible -i $(inventory-file-path)
facts-dir-path := $(CURDIR)/rc/meta
playbook-file-path := $(CURDIR)/playbook.yml
role-dir-path := $(CURDIR)/role
ansible-playbook := ansible-playbook -i $(inventory-file-path) $(playbook-file-path)

include $(CURDIR)/common.mk

check:
	ansible-playbook -i $(inventory-file-path) --check $(playbook-file-path)

play:
	ansible-playbook -i $(inventory-file-path) $(playbook-file-path)

facts:
	mkdir -p $(facts-dir-path)
	$(ansible-playbook) --tags facts | perl -WnE 'print if /^ok:.*? => /../^\}/' | perl -WpE 's/^ok:.*? => // if 1..1' | jq --indent 4 | tee $(facts-dir-path)/packages.json
	$(ansible) all -m ansible.builtin.setup | perl -WpE 's/^.*? \| SUCCESS => // if 1..1' | jq --indent 4 | tee $(facts-dir-path)/ansible-facts.json

check-connect:
	ANSIBLE_NOCOWS=1 $(ansible) -m ping all

check-inventory:
	ansible-inventory -i $(inventory-file-path) -y --list

ci-test:
	make -C module/* ci-test

debug:
	ansible-playbook -i $(inventory-file-path) --tags debug $(playbook-file-path)

pull-meta:
	php module/meta/task/pull-meta/index

index:
	mkdir -p $(CURDIR)/index/tech
	for tech in gcc make; do \
		ln -vsrfn $(CURDIR)/module/$$tech $(CURDIR)/index/tech/$$tech; \
	done

.PHONY: targets check play facts check-connect check-inventory ci-test debug pull-meta index help
