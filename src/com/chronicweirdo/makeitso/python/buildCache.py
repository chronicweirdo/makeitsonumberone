def getSub(txt,start,end):
    rtn = list()
    subobjects = [x.split(start)[1].split('\n') for x in txt.split(end) if start in x]
    for subobject in subobjects:
        temp = dict()
        for line in subobject:
            if u'=' in line and u'|' in line:
                the_predicate,the_object = line.split(u'=')
                the_predicate = the_predicate.split(u'|')[1]
                temp[the_predicate] = the_object
        if len(temp.keys()) != 0:
            rtn.append(temp)
    return rtn

def getClass(txt,class_names):
    for class_name in class_names:
        if '{{'+class_name in txt: return class_name
    return ''

def getSubobjects(txt):
    rtn = getSub(txt,'{{Single Instance Classification','}}')
    rtn += getSub(txt,'{{Instance Relationship Classification','}}')
    rtn += getSub(txt,'{{Single Instance Feature Measurement','}}')
    rtn += getSub(txt,'{{Instance Relationship Feature Measurement','}}')
    return rtn

def buildSmartCache():
    import mwclient
    site = mwclient.Site('bbpfe01.epfl.ch', path='/project/labspace/')
    user = 'bbpdaniboy@epfl.ch'
    password = '9nHZ%6RD6d'
    site.login(user, password ) # logging in to mediawiki

    rtn = dict()
    the_classes = [
        'Electrophysiological Cell Class',
        'Morphological Cell Class',
        'Molecular Cell Class',
        'Location Class'] # this is what we are looking for
    for x in the_classes: rtn[x] = list() # create a list for each class

    for page in site.pages:
        title = page.name
        text = page.edit()
        rtn[title] = getSubobjects(text) # extracting objects from text and adding them to the correct dictionary entry
        the_class = getClass(text,the_classes)
        if the_class != '':rtn[the_class].append(title)

    import pickle
    f = open('new_cache.pkl','w');pickle.dump(rtn,f);f.close()

buildSmartCache() # start the script
